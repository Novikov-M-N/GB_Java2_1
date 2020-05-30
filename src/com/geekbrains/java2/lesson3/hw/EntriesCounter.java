package com.geekbrains.java2.lesson3.hw;

import java.util.HashSet;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

public class EntriesCounter {
    private static String[] entries = {
        "First", "First", "First",
        "Second",
        "Third", "Third",
        "Fourth",
        "Fifth",
        "Sixth", "Sixth", "Sixth", "Sixth", "Sixth"
    };
    public static void main(String[] args) {
        countEntries(entries);
//        Set<String> set = new HashSet<>();
//        for(String entry:entries) {
//            if(!set.add(entry)) {}
//        }
    }
    public static void countEntries(String[] entries){
        Map<String, Integer> entryMap = new LinkedHashMap<>();
        for (String entry: entries) {
            entryMap.put(entry, entryMap.getOrDefault(entry, 0) + 1);
        }
        System.out.println(entryMap);
    }
}
