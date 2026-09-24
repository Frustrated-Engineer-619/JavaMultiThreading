package com.multithreading.threadmethod;

public class ThreadPriorityMethod {
    static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("Thread - 1");
        });

        t1.start();

        t1.setPriority(10);

        System.out.println(t1.getPriority());
    }
}
