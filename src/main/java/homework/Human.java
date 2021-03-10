package homework;

public class Human implements Interface{
    private final String name;
    private final int abilityRun;
    private final int abilityJump;
    private boolean competitor;

    public Human(String name) {
        this.name = name + ++Main.countHuman;
        abilityRun = Main.random.nextInt(5) + 1;
        abilityJump = Main.random.nextInt(5) + 1;
        competitor = true;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", выносливость=" + abilityRun +
                ", прыгучесть=" + abilityJump +
                '}';
    }

    public void run(Treadmill treadmill) {
        if(this.running(abilityRun, treadmill, name)){
            competitor = false;
        }
    }

    public void jump(Wall wall) {
        if(this.jumping(abilityJump, wall, name)){
            competitor = false;
        }
    }

    @Override
    public boolean competitor() {
        return competitor;
    }

    @Override
    public String getName() {
        return name;
    }


}
