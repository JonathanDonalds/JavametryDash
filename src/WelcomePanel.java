import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener {
    private Image BACKGROUND;
    private Image BASE;
    private Image JAVAMETRY_DASH;
    private Image JONATHAN;
    private final JFrame FRAME;
    private int jDashXCoord;
    private int jonathanXCoord;

    public WelcomePanel(JFrame frame) {
        FRAME = frame;
        try {
            BACKGROUND = ImageIO.read(new File("src/Images/Background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            BASE = ImageIO.read(new File("src/Images/Base.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            JONATHAN = ImageIO.read(new File("src/Images/Jonathan.png")).getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            JAVAMETRY_DASH = ImageIO.read(new File("src/Images/JavametryDash.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            BASE = ImageIO.read(new File("src/Images/Base.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        jonathanXCoord = 0;
        jDashXCoord = 5000;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BACKGROUND, jonathanXCoord, 0, null);
        jonathanXCoord--;
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (jonathanXCoord == -200) {
            g.drawImage(BACKGROUND, 2560, 0, null);
            jonathanXCoord = 0;
        }
        g.drawImage(JONATHAN, 50, 500, null);
        g.drawImage(JAVAMETRY_DASH, jDashXCoord, 20, null);
        g.drawImage(BASE, 0, 630, null);
        if (jDashXCoord > 400) {
            jDashXCoord--;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}