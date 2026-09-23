package com.multithreading.threadcreation;

public class ThreadDemo1 {
    static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running.");
    }
}
