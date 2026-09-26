package com.multithreading.threadproblem;

public class StaticSynchronizationDemo {
    static void main(String[] args) {
        Thread t1 = new Thread(()-> Counter1.increment());
        Thread t2 = new Thread(()-> Counter1.increment());

        t1.start();
        t2.start();
    }
}

class Counter1{
    static int count = 0;
    static void increment(){
        synchronized (Counter1.class){
            try{
                Thread.sleep(2000);
            }catch(Exception e){}
            count++;
            System.out.println(count);
        }
    }
}
