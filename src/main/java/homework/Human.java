package homework;

public class Human implements Interface{
    private final String name;
    private final int abilityRun;
    private final int abilityJump;
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

    public void run(Treadmill treadmill) {
        if(this.running(abilityRun, treadmill, name)){
            competitor = false;
        }
    }

    public void jump(Wall wall) {
        if(this.jumping(abilityRun, wall, name)){
            competitor = false;
        }
    }
    @Override
    public boolean competitor() {
        return competitor;
    }


}
