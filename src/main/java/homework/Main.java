package homework;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static ArrayList<Interface> participant = new ArrayList<>();
    public static ArrayList<Let> lets = new ArrayList<>();
    public static Random random = new Random();
    public static int countRobot = 0;
    public static int countHuman = 0;
    public static int countCat = 0;

    public static void main(String[] args) {

        inviteParticipants(10);

        obstruction(3);

        // Создание полосы препятствий;
        Let[] obstacleCourse = new Let[lets.size()];
        formationOfObstacleCourse(obstacleCourse);

        race(participant, obstacleCourse);

        winnerAnnouncement(participant);
    }

    private static void inviteParticipants(int numberOfParticipants) {
        int randomParticipants;
        for (int i = 0; i < numberOfParticipants; i++) {
            randomParticipants = random.nextInt(3) ;
            switch (randomParticipants) {
                case 0 -> participant.add(new Human("Человек №"));
                case 1 -> participant.add(new Robot("Робот №"));
                case 2 -> participant.add(new Cat("Кот №"));
            }
        }
    }

    private static void obstruction(int pairOfObstacles) {
        for (int i = 0; i < pairOfObstacles; i++ ){
            lets.add(new Treadmill());
            lets.add(new Wall());
        }
    }

    private static void formationOfObstacleCourse(Let[] obstacleCourse) {
        for (int i = 0; i < obstacleCourse.length; i++) {
            obstacleCourse[i] = lets.get(random.nextInt(lets.size()));
        }
    }

    private static void race(ArrayList<Interface> participants, Let[] obstacleCourse) {
        for (Interface participant : participants) {
           int i = 0;
            for (Let let : obstacleCourse) {
                i++;
                let.running(participant, let);
                let.jumping(participant, let);
                if (!participant.competitor())  break;
                if (i == obstacleCourse.length) System.out.println(participant.getName()
                        + " прошел все препятствия!\n");
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
