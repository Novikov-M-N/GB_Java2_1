package com.geekbrains.java2.lesson3.homework;

import java.util.ArrayList;
import java.util.ListIterator;

public class Phonebook {
    private ArrayList<String> lastName;
    private ArrayList<Long> phoneNumber;

    public Phonebook() {
        this.lastName = new ArrayList<>();
        this.phoneNumber = new ArrayList<>();
    }

    public void add(String lastName, String phoneNumber) {
        this.lastName.add(lastName);
        this.phoneNumber.add(Long.parseLong(phoneNumber));
    }

    public ArrayList<Long> get(String lastName) {
        ArrayList<Long> result = new ArrayList<>();
        ListIterator<String> iterator = this.lastName.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(lastName)) {
                result.add(this.phoneNumber.get(iterator.nextIndex()-1));
            }
        }
        return result;
    }
}
