package org.example;

import org.example.task2.Thread5;
import org.example.task2.Thread6;

public class Main {

    public static void main(String[] args) {


//        Thread thread1 = new Thread1();
//        Thread thread2 = new Thread2();
//        thread1.start();
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        thread2.start();


//        Thread thread4 = new Thread4();
//        Thread thread5 = new Thread5();
//        thread4.start();
//        thread5.start();

        Thread thread6 = new Thread6();
        Thread thread5 = new Thread5();
        thread6.start();
        thread5.start();

    }
}
