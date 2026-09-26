package com.multithreading.threadproblem;

public class ObjectLockDemo {
    static void main(String[] args) {
        Bank bank = new Bank();

        Thread t1 = new Thread(()->{
            bank.deposit();
        });

        Thread t2 = new Thread(()->{
            bank.withdraw();
        });

        t1.start();
        t2.start();
    }
}


class Bank{
    Object lock1 = new Object();
    Object lock2 = new Object();

     void deposit() {
         synchronized(lock1){
             System.out.println("Deposit Logic");
             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("Deposit Logic Ended");
         }
    }

     void withdraw(){
        synchronized (lock2){
            System.out.println("Withdraw Logic");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Withdraw Logic Ended");
        }
    }
}