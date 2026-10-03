package com.multithreading.executorframework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer>  f1 = CompletableFuture.supplyAsync(()-> 10)
//                .thenApply(result-> result*2)
//                .thenApply(result -> result*3);

//        CompletableFuture<Void>  f1 = CompletableFuture.supplyAsync(()-> 10)
//                .thenAccept(System.out::println);

//        CompletableFuture<Void>  f1 = CompletableFuture.supplyAsync(()-> 10)
//                .thenRun(() -> System.out.println("Done"));


        //thenCombine
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(()->10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(()->20);

        CompletableFuture<Void> result = f1.thenCombine(f2,(a,b) -> a+b)
                .thenAccept(System.out::println);

    }
}
/*
Fork Join Pool Executor
 */