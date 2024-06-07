import java.awt.*;

public class Sprite {
    private final Image i;
    public Sprite(Image i) {
        this.i = i;
    }

    public Image getImage() {
        return i;
    }
}