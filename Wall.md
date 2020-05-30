package geekbrains.java_level2;

public class Wall extends Obstacle {

    private int height = 1;

    public int getHeight(){
        return height;
    }

    @Override
    public boolean doIt(Competitor competitor) {
        if (competitor.jump(getHeight())){
            return true;
        }
        return false;
    }
