package lesson1Homework;

/**
 * Класс персонажа "человек"
 */

import java.util.Random;

public class Man implements Jumping, Running, Person{

    private final String name;
    private final int maxHeight;
    private final int maxDistance;

    public Man(String name) {
        Random rnd = new Random();
        this.name = name;
        this.maxHeight = 45 + rnd.nextInt(60);
        this.maxDistance = 50 + rnd.nextInt(450);
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxHeight) {
            System.out.println("Человек " + name + " перепрыгнул стену в " + height + " сантиметров");
            return true;
        } else {
            System.out.println("Человек " + name + " не осилил стену в " + height + " сантиметров");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxDistance) {
            System.out.println("Человек " + name + " пробежал дорожку " + distance + " метров");
            return true;
        } else {
            System.out.println("Человек " + name + " не осилил дорожку " + distance + " метров");
            return false;
        }
    }

    @Override
    public void hello() {
        System.out.println("Человек " + name + ". Может пробежать " + maxDistance + " метров. Высота прыжка " + maxHeight + " сантиметров");
    }

    @Override
    public String getName() {
        return name;
    }
}
