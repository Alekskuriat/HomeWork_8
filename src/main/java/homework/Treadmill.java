package homework;

public class Treadmill extends Let{
    private int length;

    public Treadmill(int length) {
        this.length = length;
        Main.lets.add(this);
    }

    public int getLength() {
        return length;
    }


}
