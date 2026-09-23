package com.multithreading.threadcreation;

public class ThreadDemo2 {
    static void main(String[] args) {
        Thread thread = new Thread(()-> System.out.println("Thread 2 is running."));
        thread.start();
    }
}
