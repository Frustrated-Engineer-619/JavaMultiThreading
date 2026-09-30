package com.multithreading.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //Number of task 5
        for(int i=1;i<=5;i++){
            int taskId = i;
            executor.execute(()->{
                System.out.println("Task " + taskId + " is performed by "+ Thread.currentThread().getName());
            });
        }
        System.out.println("checking the execution order");
        executor.shutdown();
    }
}
