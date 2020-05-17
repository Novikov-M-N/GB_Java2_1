package lesson1Homework;

/**
 * Прохождение полосы препятствий по очереди различными типами персонажей
 */
public class Competition {
    public static void main(String[] args) {
        //Создаём участников соревнований
        Person[] persons = new Person[9];
        persons[0] = new Man("Иван");
        persons[1] = new Man("Фёдор");
        persons[2] = new Man("Семён");
        persons[3] = new Cat("Соня");
        persons[4] = new Cat("Мышь");
        persons[5] = new Cat("Масик");
        persons[6] = new Robot("Феликс");
        persons[7] = new Robot("Андроид");
        persons[8] = new Robot("R2D2");

        //Формируем полосу препятствий
        Obstacle[] obstacles = new Obstacle[5];
        obstacles[0] = new Wall();
        obstacles[1] = new Treadmill();
        obstacles[2] = new Wall();
        obstacles[3] = new Wall();
        obstacles[4] = new Treadmill();

        for (Person person : persons) {
            boolean fail = false; //Если персонаж не прошёл какое-либо препятствие, то он снимается с дистанции
            person.hello();
            for (Obstacle obstacle : obstacles) {
                // В зависимости от типа препятствия выбирается способ его преодоления
                switch (obstacle.getType()) {
                    case TREADMILL:
                        if (!((Running) person).run(((Treadmill) obstacle).getDistance())) {
                            System.out.println(person.getName() + " сходит с дистанции");
                            fail = true;
                        }
                        break;
                    case WALL:
                        if (!((Jumping) person).jump(((Wall) obstacle).getHeight())) {
                            System.out.println(person.getName() + " сходит с дистанции");
                            fail = true;
                        }
                }
                if (fail) { break; }
            }
            if (!fail) { System.out.println(person.getName() + " успешно прошёл полосу препятствий"); }

        }
    }
}
