package com.geekbrains.java2.lesson3;

import java.util.*;

public class Comparation {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>(Arrays.asList(
                new Cat("A", 5), new Cat("B", 2), new Cat("C", 4)
        ));
        System.out.println(cats);
//        cats.sort(new Comparator<Cat>() {
//            @Override
//            public int compare(Cat o1, Cat o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
        Collections.sort(cats);
        System.out.println(cats);
    }

}

class Cat implements Comparable {
    private String name;

    public int getAge() {
        return age;
    }

    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat [" + name + "]";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Cat) return this.age - ((Cat) o).age;
        else return 0;
    }
}
