package com.geekbrains.java2.lesson3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new TreeSet<>();
        hashSet.add("String");
        hashSet.add("Another String");
        hashSet.add("string");
        hashSet.add("yet another string");
        for(String element: hashSet) {
            System.out.println(element);
        }
    }
}
