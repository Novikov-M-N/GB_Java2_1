package lesson1Homework;

import java.util.Random;

/**
 * Класс персонажа "кот"
 */
public class Cat implements Competitor {
    private final String name;
    private final int maxHeight;
    private final int maxDistance;

    public Cat(String name) {
        Random rnd = new Random();
        this.name = name;
        this.maxHeight = 60 + rnd.nextInt(140);
        this.maxDistance = 40 + rnd.nextInt(210);
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxHeight) {
            System.out.println("Кот " + name + " перепрыгнул стену в " + height + " сантиметров");
            return true;
        } else {
            System.out.println("Кот " + name + " не осилил стену в " + height + " сантиметров");
            return false;
        }
    }

    @Override
    public void hello() {
        System.out.println("Кот " + name + ". Может пробежать " + maxDistance + " метров. Высота прыжка " + maxHeight + " сантиметров");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxDistance) {
            System.out.println("Кот " + name + " пробежал дорожку " + distance + " метров");
            return true;
        } else {
            System.out.println("Кот " + name + " не осилил дорожку " + distance + " метров");
            return false;
        }
    }
}
