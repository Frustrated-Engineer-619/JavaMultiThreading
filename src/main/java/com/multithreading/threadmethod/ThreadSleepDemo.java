package com.multithreading.threadmethod;

import java.time.Duration;

public class ThreadSleepDemo {
    static void main(String[] args) {
        System.out.println("Main Thread Start");
        try {
            Thread.sleep(Duration.ofMinutes(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread End");
    }
}
/*
 Thread.sleep(milliseconds)  -> TIMED_WAITING
 RUNNABLE -> TIMED_WAITING  -> RUNNABLE
*/
