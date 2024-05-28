import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener, KeyListener {
    private final boolean[] PRESSEDKEYS;
    private Image BACKGROUND;
    private Image BASE;
    private Image JAVAMETRY_DASH;
    private Image JONATHAN;
    private int backgroundXCoord;
    private int jDashXCoord;
    private int jonathanYCoord;

    public WelcomePanel() {
        PRESSEDKEYS = new boolean[128];
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
        backgroundXCoord = 0;
        jDashXCoord = 1000;
        jonathanYCoord = 500;
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BACKGROUND, backgroundXCoord, -20, null);
        backgroundXCoord--;

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (backgroundXCoord == -200) {
            g.drawImage(BACKGROUND, 2560, 0, null);
            backgroundXCoord = 0;
        }

        g.drawImage(JONATHAN, 50, jonathanYCoord, null);
        g.drawImage(JAVAMETRY_DASH, jDashXCoord, 20, null);
        g.drawImage(BASE, -300, 700, null);

        if (jDashXCoord > 400) {
            jDashXCoord--;
        }

        if (jDashXCoord == 400 && PRESSEDKEYS[32]) {
            jonathanYCoord = 300;
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            jonathanYCoord = 500;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        PRESSEDKEYS[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PRESSEDKEYS[e.getKeyCode()] = false;
    }
}