package com.multithreading.threadmethod;

public class ThreadYieldDemo {
    static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                System.out.println("T1 : "+i);
                Thread.yield();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                System.out.println("T2 : "+i);
            }
        });

        t1.start();
        t2.start();
    }
}
/*
Thread.yield() : I am willing to give my CPU time to someone else with same priority.

OS can reject this.
It is like a suggestion to the OS.
Current thread does not go to WAITING, TIME_WAITING, BLOCKED
It does go to only RUNNABLE state.

*/
