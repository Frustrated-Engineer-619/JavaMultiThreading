package com.multithreading.threadmethod;

public class ThreadDaemonMethod {
    static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(true){
                System.out.println("Running....");
            }
        });

        t1.setDaemon(true);
        t1.start();
    }
}
/*
Daemon Threads --> Background running threads
--> Stop immediately once main thread is completed.

Threads --> User threads, Daemon threads

Garbage Collection - Daemon
 */
