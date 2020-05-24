package com.geekbrains.java2.lesson3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("String");
        String testString = "Test string";
        arrayList.add(testString);
        arrayList.add("Another string");
        arrayList.add("true");
        arrayList.add(1,"Second string");

        for(String element: arrayList) {
            System.out.println(element);
        }
        System.out.println("--------------");
        System.out.println("Размер списка: " + arrayList.size());
        System.out.println("Второй элемент списка: " + arrayList.get(1));
        ArrayList<String> subList = (ArrayList<String>) arrayList.subList(1,3);
        for(Object element: subList) {
            System.out.println(element);
        }
    }
}
