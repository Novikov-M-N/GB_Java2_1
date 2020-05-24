package com.geekbrains.java2.lesson3;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("String");
        String testString = "Test string";
        linkedList.add(testString);
        linkedList.add("Another string");
        linkedList.add("true");
        linkedList.add(1,"Second string");

        for(String element: linkedList) {
            System.out.println(element);
        }
        System.out.println("--------------");
        System.out.println("Размер списка: " + linkedList.size());
        System.out.println("Второй элемент списка: " + linkedList.get(1));
        ArrayList<String> subList = (ArrayList<String>) linkedList.subList(1,3);
        for(Object element: subList) {
            System.out.println(element);
        }
    }
}
