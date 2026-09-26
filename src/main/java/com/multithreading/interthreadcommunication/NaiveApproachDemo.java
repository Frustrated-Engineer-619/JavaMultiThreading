package com.multithreading.interthreadcommunication;

public class NaiveApproachDemo {
    static void main(String[] args) {
        Box1 box = new Box1();

        Thread t1 = new Thread(()-> {
            for (int i = 1; i <= 20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                box.producer(i);
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 1; i <= 20 ; i++) {
                try {
                    Thread.sleep(70);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                box.consumer();
            }
        });

        t1.start();
        t2.start();
    }

}

class Box1{
    volatile Integer item;
    volatile Boolean flag = false;

    void producer(int value){
        //if we have the value
        while(flag==true){
            //do nothing
        }
        item = value;
        flag = true;
        System.out.println("Producer produces : "+item);
    }

    void consumer(){
        //if we don't have the value
        while(flag==false){
            //do nothing
        }
        System.out.println("Consumer consumes : "+item);
        item = null;
        flag = false;
    }
}
