package homework;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static ArrayList<Interface> participants = new ArrayList<>();
    public static ArrayList<Let> lets = new ArrayList<>();


    public static void main(String[] args) {

        Random random = new Random();

        Human human1 = new Human("Федор");
        Robot robot1 = new Robot("HS-654");
        Cat cat1 = new Cat("Мурзик");
        Human human2 = new Human("Петр");
        Robot robot2 = new Robot("TG-884");
        Cat cat2 = new Cat("Томас");
        Human human3 = new Human("Иван", 5 , 3);
        Robot robot3 = new Robot("RT-741", 5,2);
        Cat cat3 = new Cat("Васька", 4,5);

        Treadmill treadmill1 = new Treadmill(random.nextInt(5)+1);
        Treadmill treadmill2 = new Treadmill(random.nextInt(5)+1);
        Treadmill treadmill3 = new Treadmill(random.nextInt(5)+1);
        Treadmill treadmill4 = new Treadmill(random.nextInt(5)+1);
        Treadmill treadmill5 = new Treadmill(random.nextInt(5)+1);

        Wall wall1 = new Wall(random.nextInt(5)+1);
        Wall wall2 = new Wall(random.nextInt(5)+1);
        Wall wall3 = new Wall(random.nextInt(5)+1);
        Wall wall4 = new Wall(random.nextInt(5)+1);
        Wall wall5 = new Wall(random.nextInt(5)+1);


        // Создание полосы препятствий;
        Let[] obstacleCourse = new Let[lets.size()];
        for (int i = 0; i < obstacleCourse.length; i++) {
            obstacleCourse[i] = lets.get(random.nextInt(lets.size()));
        }


        for (Interface participant : participants) {
            for (Let let : obstacleCourse) {
                if (let.getClass() == Treadmill.class) {
                    participant.run((Treadmill) let);
                }
                if (let.getClass() == Wall.class) {
                    participant.jump((Wall) let);
                }
                if (!participant.competitor()) {
                    break;
                }
            }
        }

        System.out.println("\nПобедители:");
        for (Interface participant : participants) {
            if (participant.competitor()) System.out.println(participant.toString());
        }
        System.out.println("\nПроигравшие:");
        for (Interface participant : participants) {
            if (!participant.competitor()) System.out.println(participant.toString());
        }


    }
}
