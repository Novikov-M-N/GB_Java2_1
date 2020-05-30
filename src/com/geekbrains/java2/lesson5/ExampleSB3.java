package com.geekbrains.java2.lesson5;

public class ExampleSB3 {
    public static void main(String[] args) {
        System.out.println("Start");
        new Thread(() -> method()).start();
        new Thread(() -> method()).start();
    }

    public synchronized static void method() { // синхронизация по классу
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ", thread: " + Thread.currentThread());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
