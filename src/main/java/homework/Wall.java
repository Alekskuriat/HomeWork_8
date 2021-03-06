package homework;

public class Wall extends Let{
    private int height;

    public Wall(int height) {
        this.height = height;
        Main.lets.add(this);
    }

    public int getHeight() {
        return height;
    }
}
