package com.multithreading.lockfreeconcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableDemo {
    static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(()->{
            for (int i = 1; i <=10000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 1; i <=10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("After incrementing counter value : "+counter.count);
    }
}


//AtomicInteger
class Counter{
    //int count = 0;
    AtomicInteger count = new AtomicInteger(0);

    void increment(){
        //count++;
        count.incrementAndGet();
    }
}
/*
t1 & t2 --> concurrently
t1 & t2 --> parallel

CAS : Compare and Set Operation

Main Method in AtomicInteger :

1. get() : to get the value
2. set(x) : to set the value x
3. incrementAndGet() : equivalent to ++x
4. getAndIncrement() : equivalent to x++
5. decrementAndGet() : equivalent to --x
6. getAndDecrement() : equivalent to x--
7. addAndGet(value) : x = x+4
8. getAndAdd(value) :


Similar to AtomicInteger we have :

AtomicLong
AtomicBoolean

synchronized ?
|-> overhead
|-> locking mechanism

 */
