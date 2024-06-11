import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {
    private int xCoord;
    private int yCoord;
    private final BufferedImage i;
    private final String name;

    public Sprite(BufferedImage i, String name) {
        this.i = i;
        this.name = name;
    }

    public BufferedImage getImage() {
        return i;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public Rectangle rect() {
        int height = getImage().getHeight();
        int width = getImage().getWidth();
        if (name.equals("Jonathan")) {
            return new Rectangle(50, yCoord, width, height);
        }
        return new Rectangle(xCoord, 655, width, height);
    }
}