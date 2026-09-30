package com.multithreading.executorframework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSubmitDemo {
    static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> value = executor.submit(()->{
            Thread.sleep(1000);
            return 10;
        });

        System.out.println(value.get());
        System.out.println("Code is stopped");
        executor.shutdown();
    }
}
