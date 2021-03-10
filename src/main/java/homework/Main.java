package homework;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static ArrayList<Interface> participants = new ArrayList<>();
    public static ArrayList<Let> lets = new ArrayList<>();
    public static Random random = new Random();

    public static void main(String[] args) {

        inviteParticipants();

        obstruction();

        // Создание полосы препятствий;
        Let[] obstacleCourse = new Let[lets.size()];
        formationOfObstacleCourse(obstacleCourse);

        race(participants, obstacleCourse);

        winnerAnnouncement(participants);


    }

    private static void inviteParticipants() {
        Human human1 = new Human("Федор");
        Robot robot1 = new Robot("HS-654");
        Cat cat1 = new Cat("Мурзик");
        Human human2 = new Human("Петр");
        Robot robot2 = new Robot("TG-884");
        Cat cat2 = new Cat("Томас");
        Human human3 = new Human("Иван", 5 , 4);
        Robot robot3 = new Robot("RT-741", 5,2);
        Cat cat3 = new Cat("Васька", 4,2);
    }

    private static void obstruction() {
        Treadmill treadmill1 = new Treadmill(5);
        Treadmill treadmill2 = new Treadmill(4);
        Treadmill treadmill3 = new Treadmill(3);
        Treadmill treadmill4 = new Treadmill(2);
        Treadmill treadmill5 = new Treadmill(1);

        Wall wall1 = new Wall(5);
        Wall wall2 = new Wall(4);
        Wall wall3 = new Wall(3);
        Wall wall4 = new Wall(2);
        Wall wall5 = new Wall(1);
    }

    private static void formationOfObstacleCourse(Let[] obstacleCourse) {
        for (int i = 0; i < obstacleCourse.length; i++) {
            obstacleCourse[i] = lets.get(random.nextInt(lets.size()));
        }
    }

    private static void race(ArrayList<Interface> participants, Let[] obstacleCourse) {
        for (Interface participant : participants) {
            for (Let let : obstacleCourse) {
                let.running(participant, let);
                let.jumping(participant, let);
                if (!participant.competitor()) {
                    break;
                }
            }
        }
    }

    private static void winnerAnnouncement(ArrayList<Interface> participants) {
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
