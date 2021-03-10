package homework;

public class Treadmill extends Let{
    private int length;

    public Treadmill() {
        this.length = Main.random.nextInt(5) + 1;
    }

    public int getLength() {
        return length;
    }

    public void running(Interface inter, Let let){
        inter.run((Treadmill) let);
    }

}
