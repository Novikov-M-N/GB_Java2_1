package geekbrains.java_level2;

public class RunTrack extends Obstacle {

    private int distance = 4;

    public int getDistance(){
        return distance;
    }

    @Override
    public boolean doIt(Competitor competitor) {
        if (competitor.run(getDistance())){
            return true;
        }
        return false;
    }
}