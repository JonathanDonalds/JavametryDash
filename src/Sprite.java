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

    public Rectangle playerRect() {
        int height = getImage().getHeight();
        int width = getImage().getWidth();
        if (name.equals("Jonathan")) {
            return new Rectangle(50, (int) yCoord, width, height);
        }
        return new Rectangle((int) xCoord, 610, width, height);
    }
}