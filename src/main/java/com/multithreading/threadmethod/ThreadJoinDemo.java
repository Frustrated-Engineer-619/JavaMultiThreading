package com.multithreading.threadmethod;

public class ThreadJoinDemo {
    static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Start");

        Thread thread1 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread-0 starts");
        });

        thread1.start();
        thread1.join();

        System.out.println("Main Thread End");
    }
}
/*
Main Thread -> waiting
t1 thread --> Runnable --> Terminated
Main Thread --> Waiting --> Runnable --> Terminated
 */
