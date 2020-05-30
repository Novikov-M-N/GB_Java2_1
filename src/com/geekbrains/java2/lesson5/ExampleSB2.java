package com.geekbrains.java2.lesson5;

public class ExampleSB2 {
    private Object lock1 = new Object();

    public static void main(String[] args) {
        ExampleSB2 e2 = new ExampleSB2();
        System.out.println("Start");
        new Thread(() -> e2.method1()).start();
        new Thread(() -> e2.method1()).start();
    }

    public void method1() {
        System.out.println("Block-1 begin, thread:" + Thread.currentThread());
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Block-1 end, thread:" + Thread.currentThread());
        synchronized (lock1) {
            System.out.println("Synch block begin, thread:" + Thread.currentThread());
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Synch block end, thread:" + Thread.currentThread());
        }
        System.out.println("M2, thread:" + Thread.currentThread());
    }
}