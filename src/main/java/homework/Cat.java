package homework;

public class Cat implements Interface{
    private String name;
    private int abilityRun;
    private int abilityJump;
    private boolean competitor;

    public Cat(String name) {
        this.name = name;
        abilityRun = 2;
        abilityJump = 2;
        competitor = true;
        Main.participants.add(this);;
    }

    public Cat(String name, int abilityRun, int abilityJump) {
        this.name = name;
        this.abilityRun = abilityRun;
        this.abilityJump = abilityJump;
        competitor = true;
        Main.participants.add(this);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", выносливость=" + abilityRun +
                ", прыгучесть=" + abilityJump +
                '}';
    }

    @Override
    public void run(Treadmill treadmill) {
        if (abilityRun < treadmill.getLength()) {
            System.out.println("Длина забега: " + treadmill.getLength() + "       | "
                    + name + " не может пробежать так много");
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
