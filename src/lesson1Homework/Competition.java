package lesson1Homework;

/**
 * Прохождение полосы препятствий по очереди различными типами персонажей
 */
public class Competition {
    public static void main(String[] args) {
        //Создаём участников соревнований
        Competitor[] competitors = new Competitor[9];
        competitors[0] = new Man("Иван");
        competitors[1] = new Man("Фёдор");
        competitors[2] = new Man("Семён");
        competitors[3] = new Cat("Соня");
        competitors[4] = new Cat("Мышь");
        competitors[5] = new Cat("Масик");
        competitors[6] = new Robot("Феликс");
        competitors[7] = new Robot("Андроид");
        competitors[8] = new Robot("R2D2");

        //Формируем полосу препятствий
        Obstacle[] obstacles = new Obstacle[5];
        obstacles[0] = new Wall();
        obstacles[1] = new Treadmill();
        obstacles[2] = new Wall();
        obstacles[3] = new Wall();
        obstacles[4] = new Treadmill();

        for (Competitor competitor : competitors) {
            boolean fail = false; //Если персонаж не прошёл какое-либо препятствие, то он снимается с дистанции
            competitor.hello();
            for (Obstacle obstacle : obstacles) {
                // В зависимости от типа препятствия выбирается способ его преодоления
                switch (obstacle.getType()) {
                    case TREADMILL:
                        if (!competitor.run(((Treadmill)obstacle).getDistance())) {
                            System.out.println(competitor.getName() + " сходит с дистанции");
                            fail = true;
                        }
                        break;
                    case WALL:
                        if (!competitor.jump(((Wall) obstacle).getHeight())) {
                            System.out.println(competitor.getName() + " сходит с дистанции");
                            fail = true;
                        }
                }
                if (fail) { break; }
            }
            if (!fail) { System.out.println(competitor.getName() + " успешно прошёл полосу препятствий"); }

        }
    }
}
