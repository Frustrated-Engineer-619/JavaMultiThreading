package com.multithreading.threadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    static void main(String[] args) {
        Resource resource = new Resource();

        Thread t1 = new Thread(resource::m1);
        Thread t2 = new Thread(resource::m1);
        Thread t3 = new Thread(resource::m1);
        Thread t4 = new Thread(resource::m1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class Resource{

    Lock lock = new ReentrantLock();

    void m1(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" entered");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" exited");
        }
        finally {
            lock.unlock();
        }

    }
}
