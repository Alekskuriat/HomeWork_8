package homework;

public class Cat implements Interface{
    private final String name;
    private final int abilityRun;
    private final int abilityJump;
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
