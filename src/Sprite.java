import java.awt.*;

public class Sprite {
    private int xCoord;
    private int yCoord;
    private final Image i;
    private String name;
    public Sprite(Image i, String name) {
        this.i = i;
        this.name = name;
    }

    public Image getImage() {
        return i;
    }

    public Rectangle playerRect() {
        int height = getImage().getHeight();
        int width = getImage().getWidth();
        if (name.equals("Jonathan")) {
            return new Rectangle(50, (int) yCoord, width, height);
        }
        return new Rectangle((int) xCoord, 610, width, height);
    }
}