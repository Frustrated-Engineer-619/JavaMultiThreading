package com.multithreading.threadmethod;

public class ThreadInterruptMethod {
    static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Running");
            }
        });

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
/*

Thread  --> interrupt flag (default false)

t1.interrupt() : sends a signal to t1 Thread that it should stop doing what it is doing.
Makes flag to true


We can gracefully handle
--> You cna make a thread run until a condition
--> Cancelling a long running task
--> used to stop thread poll

isInterrupted() -> return interrupt flag value (T/F)
interrupted() -> return interrupt flag value (T/F) but also set it back to false

*/
