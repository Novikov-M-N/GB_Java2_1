package lesson1Homework;

import java.util.Random;

/**
 * Класс персонажа "робот"
 */
public class Robot implements Competitor {
    private final String name;
    private final int maxHeight;
    private final int maxDistance;

    public Robot(String name) {
        Random rnd = new Random();
        this.name = name;
        this.maxHeight = 10 + rnd.nextInt(80);
        this.maxDistance = 130 + rnd.nextInt(670);
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxHeight) {
            System.out.println("Робот " + name + " перепрыгнул стену в " + height + " сантиметров");
            return true;
        } else {
            System.out.println("Робот " + name + " не осилил стену в " + height + " сантиметров");
            return false;
        }
    }

    @Override
    public void hello() {
        System.out.println("Робот " + name + ". Может пробежать " + maxDistance + " метров. Высота прыжка " + maxHeight + " сантиметров");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxDistance) {
            System.out.println("Робот " + name + " пробежал дорожку " + distance + " метров");
            return true;
        } else {
            System.out.println("Робот " + name + " не осилил дорожку " + distance + " метров");
            return false;
        }
    }
}
