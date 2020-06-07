package com.geekbrains.java2.lesson5.hw;

import java.util.Arrays;

public class Calculator {
    public static int SIZE = 1_000_000;
    public static int HALF_SIZE = SIZE/2;
    private static Float[] singleThreadArray = new Float[SIZE];
    private static Float[] doubleThreadArray = new Float[SIZE];

    public static void calculate(Float[] array, int start, int stop) {
        for (int i = start; i < stop; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void main(String[] args) {
        Arrays.fill(singleThreadArray, 1.0f);
        Arrays.fill(doubleThreadArray, 1.0f);
        long startTime = System.currentTimeMillis();
        calculate(singleThreadArray, 0, SIZE);
        System.out.println("Последовательное вычисление: " + (System.currentTimeMillis() - startTime) + " мс");
        Float[] a1 = new Float[HALF_SIZE];
        Float[] a2 = new Float[HALF_SIZE];
        startTime = System.currentTimeMillis();
//        System.arraycopy(doubleThreadArray, 0, a1, 0, HALF_SIZE);
//        System.arraycopy(doubleThreadArray, HALF_SIZE, a2, 0, HALF_SIZE);
        Thread thread1 = new Thread(() -> calculate(doubleThreadArray, 0, HALF_SIZE));
        Thread thread2 = new Thread(() -> calculate(doubleThreadArray, HALF_SIZE+1, SIZE));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
//        System.arraycopy(a1, 0, doubleThreadArray, 0, HALF_SIZE);
//        System.arraycopy(a2, 0, doubleThreadArray, HALF_SIZE, HALF_SIZE);
        System.out.println("Параллельное вычисление: " + (System.currentTimeMillis() - startTime) + " мс");
    }
}
