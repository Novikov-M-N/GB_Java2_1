package lesson1Homework;

/**
 * Обобщённый класс препятствия
 */
public abstract class Obstacle {
    private final ObstacleType type;

    public Obstacle(ObstacleType type) {
        this.type = type;
    }

    public ObstacleType getType() {
        return type;
    }

    @Override
    public abstract String toString();
}
