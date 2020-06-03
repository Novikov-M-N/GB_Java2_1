package com.geekbrains.java2.lesson5.homework;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size/2;

    static void arrayCalculate(float[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = (float)(inputArray[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
    }

    static long singleThread(float[] inputArray) {
        Arrays.fill(inputArray, 1);
        long timeOfStart = System.currentTimeMillis();
        arrayCalculate(inputArray);
        return System.currentTimeMillis() - timeOfStart;
    }

    static long multiThread(float[] inputArray) {
        Arrays.fill(inputArray, 1);
        long timeOfStart = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(inputArray, 0, arr1, 0, h);
        System.arraycopy(inputArray, h, arr2, 0, h);
        Thread thread1 = new Thread(() -> arrayCalculate(arr1));
        Thread thread2 = new Thread(() -> arrayCalculate(arr2));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, inputArray, 0, h);
        System.arraycopy(arr2, 0, inputArray, h, h);
        return System.currentTimeMillis() - timeOfStart;
    }

    public static void main(String[] args) {
        float[] arr = new float[size];
        System.out.println(singleThread(arr));
        System.out.println(multiThread(arr));
    }
}
