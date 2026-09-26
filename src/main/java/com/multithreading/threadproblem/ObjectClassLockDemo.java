package com.multithreading.threadproblem;

public class ObjectClassLockDemo {
    static void main(String[] args) {
        Test1 test1 = new Test1();

        Thread t1 = new Thread(()->Test1.m1());
        Thread t2 = new Thread(()->test1.m2());

        t1.start();
        t2.start();
    }
}

class Test1{
    static void m1(){
        synchronized (Test1.class){
            System.out.println("m1 entered");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("m1 exit");
        }
    }

    synchronized void m2(){
        System.out.println("m2 entered");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("m2 exit");
    }
}
