package homework;

public class Human implements Interface{
    private String name;
    private int abilityRun;
    private int abilityJump;
    private boolean competitor;

    public Human(String name) {
        this.name = name;
        abilityRun = 3;
        abilityJump = 3;
        competitor = true;
        Main.participants.add(this);
    }

    public Human(String name, int abilityRun, int abilityJump) {
        this.name = name;
        this.abilityRun = abilityRun;
        this.abilityJump = abilityJump;
        competitor = true;
        Main.participants.add(this);

    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", выносливость=" + abilityRun +
                ", прыгучесть=" + abilityJump +
                '}';
    }

    @Override
    public void run(Treadmill treadmill) {
        if (abilityRun < treadmill.getLength()) {
            System.out.println("Длина забега: " + treadmill.getLength() + "       | " +
                    name + " не может пробежать так много");
            System.out.println(name + " выбывает из соревнований");
            competitor = false;
        } else
            System.out.println("Длина забега: " + treadmill.getLength() + "       | "
                    + name + " бежит");

    }

    @Override
    public void jump(Wall wall) {
        if (abilityJump < wall.getHeight()) {
            System.out.println("Высота препятствия: " + wall.getHeight() + " | "
                    + name + " не может так высоко прыгнуть");
            System.out.println(name + " выбывает из соревнований");
            competitor = false;
        } else
            System.out.println("Высота препятствия: " + wall.getHeight() + " | "
                    + name + " преодолел препятствие");
    }

    @Override
    public boolean competitor() {
        return competitor;
    }


}
