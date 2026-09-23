package com.multithreading.threadcreation;

public class ThreadDemo3 {
    static void main(String[] args) {
        Runnable task = ()->{
            System.out.println("Current Thread running : "+Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(task,"worker-thread-1");
        Thread thread2 = new Thread(task,"worker-thread-2");

        thread1.start();
        thread2.start();

        System.out.println("Current Thread : "+Thread.currentThread().getName()+" Program ends");
    }
}
