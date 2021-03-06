package homework;

public interface Interface {
    void run(Treadmill treadmill);
    void jump(Wall wall);

    default boolean competitor() {
        return false;
    }

}
