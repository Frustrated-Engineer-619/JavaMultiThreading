package com.multithreading.threadlock;

import java.util.concurrent.locks.StampedLock;

public class OptimisticReadDemo {
    static void main(String[] args) {
        SharedResource1 resource = new SharedResource1();
        Thread r1 = new Thread(resource::read);
        Thread r2 = new Thread(resource::read);
        Thread r3 = new Thread(resource::read);


        Thread w1 = new Thread(()-> resource.write(10));
        Thread w2 = new Thread(()-> resource.write(20));
        Thread w3 = new Thread(()-> resource.write(30));


        r1.start();
        r2.start();
        r3.start();
        w1.start();
        w2.start();
        w3.start();
    }
}
/*
1. Get a stamp
2. Read data without locking
3. Checking if data is Modified
*/

class SharedResource1{
    private int value = 0;

    StampedLock lock = new StampedLock();

    public int read(){
        long stamp = lock.tryOptimisticRead();
        int currentValue = value;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(lock.validate(stamp)==false){
            //fallover logic
            //try pessimistic read
            stamp = lock.readLock();
            try{
                currentValue = value;
            }finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName()+" reads value as "+currentValue);
        return currentValue;
    }

    public void write(int newValue){
        long stamp = lock.writeLock();
        try{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            value = newValue;
            System.out.println(Thread.currentThread().getName()+" changes value to "+value);
        }finally {
            lock.unlockWrite(stamp);
        }
    }
}

