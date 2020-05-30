package com.geekbrains.java2.lesson5;

public class ExampleSB5 {
     static int amount = 100;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread thread1 = new Thread(() -> method());
        thread1.start();
        Thread thread2 = new Thread(() -> method());
        thread2.start();
        Thread thread3 = new Thread(() -> method());
        thread3.start();
        Thread thread4 = new Thread(() -> method());
        thread4.start();
        Thread thread5 = new Thread(() -> method());
        thread5.start();
        Thread thread6 = new Thread(() -> method());
        thread6.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        System.out.println("Amount: " + amount);
    }

    public synchronized static void method() { // синхронизация по классу
        System.out.println(Thread.currentThread().getId());
        if (Thread.currentThread().getId() %2 == 0) {
            amount += 50;
        } else {
            amount -= 50;
        }
    }
}
