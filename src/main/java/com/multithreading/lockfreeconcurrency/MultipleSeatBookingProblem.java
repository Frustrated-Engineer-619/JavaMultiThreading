package com.multithreading.lockfreeconcurrency;

import java.util.concurrent.atomic.AtomicReference;

public class MultipleSeatBookingProblem {
    static void main(String[] args) throws InterruptedException {
        SeatBooking seatBooking = new SeatBooking();
        Thread t1 = new Thread(()-> {
            boolean value = seatBooking.bookSeat("Pallavi");
            System.out.println("T1 says : "+value);
        });
        Thread t2 = new Thread(()-> {
            boolean value = seatBooking.bookSeat("Navneet");
            System.out.println("T2 says : "+value);
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(seatBooking.seat);
    }
}

class SeatBooking{
    //String seat = new String("EMPTY");
    AtomicReference<String> seat = new AtomicReference<>("EMPTY");
    boolean bookSeat(String name){
        String currentValue = seat.get();
        if(currentValue.equals("EMPTY")==false){
            return false;
        }
        return seat.compareAndSet("EMPTY",name);
    }

//    boolean bookSeat(String name){
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        if(seat.equals("EMPTY")){
//            seat = new String(name);
//            System.out.println("Seat got booked for a person : "+name);
//            return true;
//        }
//        return false;
//    }
}

/*
Compare and Set Operation
 */


/*

synchronized
ReentrantLock
lock.lock()
try{
    //critical section code
}
finally{
    lock.unlock()
}



 */
