package geekbrains.java_level2;

public class Robot implements Competitor {

    private int maxJumpHeight = 2;
    private int maxRunDistance = 5;


    @Override
    public boolean jump(int height) {
        if(maxJumpHeight > height) {
            System.out.println("Робот успешно прыгнул");
            return true;
        } else {
            System.out.println("Робот не смог прыгнуть");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if(maxRunDistance >= distance) {
            System.out.println("Робот успешно пробежал");
            return true;
        } else {
            System.out.println("Робот не смог пробежать");
            return false;
        }
    }

}