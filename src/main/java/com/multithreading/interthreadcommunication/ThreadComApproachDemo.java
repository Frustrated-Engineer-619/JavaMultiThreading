package com.multithreading.interthreadcommunication;

public class ThreadComApproachDemo {
    static void main(String[] args) {

    }

    class Box2{
        volatile Integer item;
        volatile Boolean flag = false;

        void producer(int value){
            //if we have the value
            while(flag==true){
                //Thread should wait so that consumer thread can consume
            }
            item = value;
            flag = true;
            System.out.println("Producer produces : "+item);
        }

        void consumer(){
            //if we don't have the value
            while(flag==false){
                //Thread should wait for the producer threas to produce
            }
            System.out.println("Consumer consumes : "+item);
            item = null;
            flag = false;
        }
    }
}
/*

wait : pause -> lock(release) -> waiting

 */
