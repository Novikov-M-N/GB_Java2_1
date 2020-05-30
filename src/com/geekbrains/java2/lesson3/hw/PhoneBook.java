package com.geekbrains.java2.lesson3.hw;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new TreeMap<>();

    public void add(String surname, String phone) {
        Set<String> entry = phoneBook.getOrDefault(surname, new LinkedHashSet<>());
        entry.add(phone);
        phoneBook.put(surname, entry);
    }

    public Set<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new HashSet<>());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Smith","555-55-55");
        phoneBook.add("Jackson","123-45-67");
        phoneBook.add("Smith","111-11-11");
        System.out.println("Smith: " + phoneBook.get("Smith"));
        System.out.println("Peterson: " + phoneBook.get("Peterson"));
//        System.out.println(phoneBook.phoneBook.entrySet());
    }
}
