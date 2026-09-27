package com.multithreading.threadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    static void main(String[] args) {
        SharedResource resource = new SharedResource();
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
Multiple threads can read at the same time, but only one thread can write at a time.
Reading and writing cannot happen at the same time.
 */

class SharedResource{
    private int value = 0;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock rl = readWriteLock.readLock(); //shared
    Lock wl = readWriteLock.writeLock(); //exclusive

    public int read(){
        rl.lock();
        try{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" reads value as "+value);
            return value;
        }finally {
            rl.unlock();
        }
    }

    public void write(int newValue){
        wl.lock();
        try{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            value = newValue;
            System.out.println(Thread.currentThread().getName()+" changes value to "+value);
        }finally {
            wl.unlock();
        }

    }
}
