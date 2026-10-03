package com.multithreading.executorframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExecutorDemo {
    static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        SumTask task = new SumTask(arr,0,arr.length-1);

        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(task);
        System.out.println(result);
        pool.shutdown();
    }
}

//Fork Join pool executor
class SumTask extends RecursiveTask<Integer>{
    private int arr[];
    private int start;
    private int end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute(){
        //base condition
        if(end-start<=2){
            int sum = 0;
            for(int i=start;i<=end;i++){
                sum+=arr[i];
            }
            return sum;
        }

        //main logic
        int mid = start + (end-start)/2;
        SumTask leftTask = new SumTask(arr,start,mid);
        SumTask rightTask = new SumTask(arr,mid+1,end);

        leftTask.fork();
        int sum2 = rightTask.compute();
        int sum1 = leftTask.join();

        //join
        return sum1+sum2;
    }
}