import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener {
    private BufferedImage BACKGROUND;
    private final JFrame FRAME;
    private int xCoord;

    public WelcomePanel(JFrame frame) {
        FRAME = frame;
        try {
            BACKGROUND = ImageIO.read(new File("src/Images/Background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        xCoord = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BACKGROUND, xCoord, 0, null);
        xCoord--;
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (xCoord == -200) {
            g.drawImage(BACKGROUND, 2560, 0, null);
            xCoord = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}