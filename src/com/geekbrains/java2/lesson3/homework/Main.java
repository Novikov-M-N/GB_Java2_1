package com.geekbrains.java2.lesson3.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("раз");
        words.add("два");
        words.add("три");
        words.add("три");
        words.add("четыре");
        words.add("пять");
        words.add("пять");
        words.add("четыре");
        words.add("два");
        words.add("четыре");
        words.add("три");
        words.add("пять");
        words.add("пять");
        words.add("пять");
        words.add("четыре");

        System.out.println("Исходный массив:");
        System.out.println(words);

        TreeSet<String> uniqueWords = new TreeSet<>(words);
        System.out.println("Уникальные значения исходного массива:");
        System.out.println(uniqueWords);

        HashMap<String, Integer> counterOfUniqueWords = new HashMap<>();
        for (String word: words) {
            if(counterOfUniqueWords.containsKey(word)) {
                int counter = counterOfUniqueWords.get(word) + 1;
                counterOfUniqueWords.put(word,counter);
            } else {
                counterOfUniqueWords.put(word, 1);
            }
        }
        System.out.println("Сколько раз в исходном массиве встречается каждое слово:");
        System.out.println(counterOfUniqueWords);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов",     "9230000001");
        phonebook.add("Петров",     "9130000001");
        phonebook.add("Сидоров",    "9610000001");
        phonebook.add("Алексеев",   "9520000001");
        phonebook.add("Сидоров",    "9610000002");
        phonebook.add("Петров",     "9130000002");
        phonebook.add("Алексеев",   "9520000002");
        phonebook.add("Алексеев",   "9520000003");
        phonebook.add("Алексеев",   "9520000004");
        phonebook.add("Сидоров",    "9610000003");

        System.out.println("Телефоны Иванова:");
        System.out.println(phonebook.get("Иванов"));
        System.out.println("Телефоны Петрова:");
        System.out.println(phonebook.get("Петров"));
        System.out.println("Телефоны Сидорова:");
        System.out.println(phonebook.get("Сидоров"));
        System.out.println("Телефоны Алексеева:");
        System.out.println(phonebook.get("Алексеев"));
        System.out.println("Запрос к несуществующей фамилии:");
        System.out.println(phonebook.get("Семёнов"));
    }

}
