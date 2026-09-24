package com.multithreading.threadmethod;

public class ThreadIsAliveMethod {
    static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(t1.isAlive());
        t1.start();
        System.out.println(t1.isAlive());

        Thread.sleep(3000);

        System.out.println(t1.isAlive());
    }
}
