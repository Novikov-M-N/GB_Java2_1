package lesson1Homework;

import java.util.Random;

/**
 * Класс препятствия "стена"
 */
public class Wall extends Obstacle{
    private final int height;

    public int getHeight() {
        return height;
    }

    public Wall() {
        super(ObstacleType.WALL);
        Random rnd = new Random();
        this.height = 20 + rnd.nextInt(80);
    }

    @Override
    public String toString() {
        return "Стена высотой " + height + " сантиметров";
    }
}
