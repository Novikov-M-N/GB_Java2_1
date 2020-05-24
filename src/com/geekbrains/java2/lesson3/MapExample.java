package com.geekbrains.java2.lesson3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String args[]) {
        TreeMap<String, String> hm = new TreeMap<>();
        hm.put("Russia", "Moscow");
        hm.put("France", "Paris");
        hm.put("Germany", "Berlin");
        hm.put("Norway", "Oslo");
        for (Map.Entry<String, String> o : hm.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }
        if (hm.containsKey("Turkey")) hm.put("Germany", "Berlin2");
        else System.out.println("No such key");
        System.out.println("New Germany Entry: " + hm.get("Germany"));
    }

}
