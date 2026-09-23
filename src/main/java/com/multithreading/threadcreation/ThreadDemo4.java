package com.multithreading.threadcreation;

public class ThreadDemo4 {
    static void main(String[] args) {
        Thread evenThread = new Thread(()->{
            for(int i=1;i<=10;i++){
                if(i%2==0){
                    System.out.println("Current Thread - ["+Thread.currentThread().getName()+"] "+"Even : "+i);
                }
            }
        },"Even-Thread");

        Thread oddThread = new Thread(()->{
            for(int i=1;i<=10;i++){
                if(i%2!=0){
                    System.out.println("Current Thread - ["+Thread.currentThread().getName()+"] "+"Even : "+i);
                }
            }
        },"Odd-Thread");

        System.out.println("Even Thread State : "+ evenThread.getState());
        System.out.println("Odd Thread State : "+ oddThread.getState());

        evenThread.start();
        oddThread.start();
    }
}
