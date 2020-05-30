package geekbrains.java_level2;

public interface Runnable {
    void run(int distance);
}

public interface Jumpable {
    void jump(int height);
}

public class Human implements Runnable, Jumpable {

    private int maxJumpHeight = 2;
    private int maxRunDistance = 4;

    @Override
    public void jump(int height) {
        if (maxJumpHeight > height) {
            System.out.println("Человек успешно прыгнул");
        } else {
            System.out.println("Человек не смог прыгнуть");
        }
    }

    @Override
    public void run(int distance) {
        if (maxRunDistance >= distance) {
            System.out.println("Человек успешно пробежал");
        } else {
            System.out.println("Человек не смог пробежать");
        }
    }
}

public class Cat implements Runnable, Jumpable {

    private int maxJumpHeight = 3;
    private int maxRunDistance = 2;

    @Override
    public void jump(int height) {
        if(maxJumpHeight > height) {
            System.out.println("Кот успешно прыгнул");
        } else {
            System.out.println("Кот не смог прыгнуть");
        }
    }

    @Override
    public void run(int distance) {
        if(maxRunDistance >= distance) {
            System.out.println("Кот успешно пробежал");
        } else {
            System.out.println("Кот не смог пробежать");
        }
    }
}

public class Robot implements Runnable, Jumpable {

    private int maxJumpHeight = 2;
    private int maxRunDistance = 5;


    @Override
    public void jump(int height) {
        if(maxJumpHeight > height) {
            System.out.println("Робот успешно прыгнул");
        } else {
            System.out.println("Робот не смог прыгнуть");
        }
    }

    @Override
    public void run(int distance) {
        if(maxRunDistance >= distance) {
            System.out.println("Робот успешно пробежал");
        } else {
            System.out.println("Робот не смог пробежать");
        }
    }
}

public class Obstacle {
    public void doIt(Runnable runnable){
    }
}

public class Wall extends Obstacle {

    private int height = 1;

    public int getHeight(){
        return height;
    }

    @Override
    public void doIt(Runnable runnable) {
        ((Jumpable)runnable).jump(getHeight());
    }
}

public class RunTrack extends Obstacle {

    private int distance = 4;

    public int getDistance(){
        return distance;
    }

    @Override
    public void doIt(Runnable runnable) {
        runnable.run(getDistance());
    }
}

public class Test {

    public static void main(String[] args) {

        Runnable human = new Human();
        Runnable cat = new Cat();
        Runnable robot = new Robot();

        Runnable[] team = {human,cat,robot};

        Obstacle wall = new Wall();
        Obstacle track = new RunTrack();

        Obstacle[] cross = {wall,track};

        for(Runnable tm : team){
            for(Obstacle obs : cross){
                obs.doIt(tm);
            }
        }
    }
}
