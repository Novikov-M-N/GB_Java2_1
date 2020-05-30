package geekbrains.java_level2;

public class Test {

    public static void main(String[] args) {


        Competitor[] team = {new Human(),new Cat(),new Robot()};

        Obstacle[] cross = {new Wall(),new RunTrack()};

        for(Competitor tm : team){
            for(Obstacle obs : cross){
                if (!obs.doIt(tm)){
                    break;
                }
            }
        }
    }
}
