package homework;

public class Wall extends Let{
    private int height;

    public Wall() {
        this.height = Main.random.nextInt(5) + 1;
    }

    public int getHeight() {
        return height;
    }

    public void jumping(Interface inter, Let let){
        inter.jump((Wall) let);
    }
}
