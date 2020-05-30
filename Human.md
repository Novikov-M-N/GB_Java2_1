package geekbrains.java_level2;

public class Human implements Competitor {

    private int maxJumpHeight = 2;
    private int maxRunDistance = 4;

    @Override
    public boolean jump(int height) {
        if (maxJumpHeight > height) {
            System.out.println("Человек успешно прыгнул");
            return true;
        } else {
            System.out.println("Человек не смог прыгнуть");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (maxRunDistance >= distance) {
            System.out.println("Человек успешно пробежал");
            return true;
        } else {
            System.out.println("Человек не смог пробежать");
            return false;
        }
    }


}