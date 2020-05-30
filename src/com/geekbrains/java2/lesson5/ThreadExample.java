package com.geekbrains.java2.lesson5;

public class ThreadExample {
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("new thread: " + Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread thread1 = new MyThread();
        thread1.setName("My first thread");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        Thread thread2 = new MyThread();
        thread2.setName("Маловажный поток");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
    }
    //NEW
    //RUNNABLE
    //BLOCKED
    //WAITING
    //TIMED_WAITING
    //TERMINATED
    //Проблемы:
    //1. Голодание (Starvation)
    //2. Гонки потоков (Race condition)
    //3. Взаимоблокировки (Deadlocks)
}
