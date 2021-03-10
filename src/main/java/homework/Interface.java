package homework;

public interface Interface {
    void run(Treadmill treadmill);
    void jump(Wall wall);
    String getName();

    default boolean competitor() {
        return false;
    }
    default boolean running(int abilityRun, Treadmill treadmill, String name){
        if (abilityRun < treadmill.getLength()) {
            System.out.println("Длина забега: " + treadmill.getLength() + "       | "
                    + name + " не может пробежать так много");
            System.out.println(name + " выбывает из соревнований\n");
            return true;
        } else
            System.out.println("Длина забега: " + treadmill.getLength() + "       | "
                    + name + " бежит");
        return false;
    }
    default boolean jumping(int abilityJump, Wall wall, String name){
        if (abilityJump < wall.getHeight()) {
            System.out.println("Высота препятствия: " + wall.getHeight() + " | "
                    + name + " не может так высоко прыгнуть");
            System.out.println(name + " выбывает из соревнований\n");
            return true;
        } else
            System.out.println("Высота препятствия: " + wall.getHeight() + " | "
                    + name + " преодолел препятствие");
        return false;
    }


}
