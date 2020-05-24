package com.geekbrains.java2.lesson2;

public class Throwing {
    public static void main(String[] args) {
        try {
            method();
        } catch (NullPointerException е) {
            System.out.println("Catch block");
        }
    }

    static void method() throws NullPointerException {
        throw new NullPointerException("NPE Test");
    }
}
