package geekbrains.java_level2;

public class Cat implements Competitor {

    private int maxJumpHeight = 3;
    private int maxRunDistance = 2;

    @Override
    public boolean jump(int height) {
        if(maxJumpHeight > height) {
            System.out.println("Кот успешно прыгнул");
            return true;
        } else {
            System.out.println("Кот не смог прыгнуть");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if(maxRunDistance >= distance) {
            System.out.println("Кот успешно пробежал");
            return true;
        } else {
            System.out.println("Кот не смог пробежать");
            return false;
        }
    }


}