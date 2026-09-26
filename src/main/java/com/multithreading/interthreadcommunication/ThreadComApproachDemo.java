package com.multithreading.interthreadcommunication;

public class ThreadComApproachDemo {
    static void main(String[] args) {
        Box2 box = new Box2();

        Thread t1 = new Thread(()-> {
            for (int i = 1; i <= 20; i++) {
                try {
                    Thread.sleep(100);
                    box.producer(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 1; i <= 20 ; i++) {
                try {
                    Thread.sleep(100);
                    box.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class Box2{
    volatile Integer item;
    volatile Boolean flag = false;

    synchronized void producer(int value) throws InterruptedException {
        //if we have the value
        while(flag==true){
            wait();
        }
        item = value;
        flag = true;
        System.out.println("Producer produces : "+item);
        notify();
    }

    synchronized void consumer() throws InterruptedException {
        //if we don't have the value
        while(flag==false){
            wait();
        }
        System.out.println("Consumer consumes : "+item);
        item = null;
        flag = false;
        notify();
    }
}
/*

wait : pause -> lock(release) -> waiting
1. Release monitor locks
2. Goes to the waiting state.
3. It stays there, until another thread wakes it up.

wait() -> synchronized() ---Used wait() inside the synchronized block
|-> Exception -> IllegalMonitorStateException


Object
|--> Monitor Locks
       |--> OwnerThread
       |--> WaitingQueue = []

notify() -> synchronized()
1. One Random thread is picked from waiting queue
2. That thread -> Blocked state
3. Compete for the lock
4. Once lock occupied -> RUNNING


notifyAll() :

1. All threads in waiting queue are moved to BLOCKED state.
2. They all try to acquire the lock.
3. Only one gets the lock at a time.

*/
