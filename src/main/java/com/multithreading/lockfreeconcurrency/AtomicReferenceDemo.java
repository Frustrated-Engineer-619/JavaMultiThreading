package com.multithreading.lockfreeconcurrency;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    static void main(String[] args) throws InterruptedException {
        LikeCounter likeCounter = new LikeCounter();

        Thread t1 = new Thread(likeCounter::like);
        Thread t2 = new Thread(likeCounter::like);
        Thread t3 = new Thread(likeCounter::like);
        Thread t4 = new Thread(likeCounter::like);
        Thread t5 = new Thread(likeCounter::like);
        Thread t6 = new Thread(likeCounter::like);
        Thread t7 = new Thread(likeCounter::like);
        Thread t8 = new Thread(likeCounter::like);
        Thread t9 = new Thread(likeCounter::like);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();


        Thread.sleep(3000);

        System.out.println("Total Likes "+likeCounter.getTotalLikes());
    }
}

class LikeCounter{
    AtomicReference<Integer> totalCount = new AtomicReference<>(0);

    public void like(){
        Integer currentCount;
        Integer finalCount;
        while(true){
            //1.we will capture the latest value of totalCount
            currentCount = totalCount.get();
            //2.Increment like counter by 1
            finalCount =  currentCount+1;

            //3.Check count if the count is still what I saw
            if(totalCount.compareAndSet(currentCount,finalCount)){
                return;
            }
            //4.If a thread reached here,someone  else might have updated their count
            // Re-try
            System.out.println("Conflict detected. Retrying ....");
        }
    }

    public Integer getTotalLikes(){
        return totalCount.get();
    }
}
