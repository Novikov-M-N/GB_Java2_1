package lesson1Homework;

import java.util.Random;

/**
 * Класс препятствия "беговая дорожка"
 */
public class Treadmill extends Obstacle{
    private final int distance;

    public int getDistance() {
        return distance;
    }

    public Treadmill() {
        super(ObstacleType.TREADMILL);
        Random rnd = new Random();
        this.distance = 100 + rnd.nextInt(300);
    }

    @Override
    public String toString() {
        return "Беговая дорожка длиной " + distance + " метров";
    }
}
