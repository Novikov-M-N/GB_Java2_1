package com.geekbrains.java2.lesson5;

public class ExampleSB1 {
    public static void main(String[] args) {
        ExampleSB1 e1 = new ExampleSB1();
        System.out.println("Start");
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method2()).start();
        new Thread(() -> e1.method3()).start();
    }
    public synchronized void method1() {
        System.out.println("M1 from " + Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2 from " + Thread.currentThread());
    }
    public synchronized void method2() {
        System.out.println("M1 from " + Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2 from " + Thread.currentThread());
    }
    public void method3() {
        System.out.println("M1 from " + Thread.currentThread());
        synchronized(this){ for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
        System.out.println("M2 from " + Thread.currentThread());
    }
}