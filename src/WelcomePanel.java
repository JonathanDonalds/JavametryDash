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
        private boolean stop;
    private final boolean[] PRESSEDKEYS;
    private Image background;
    private Image base;
    private Image javametryDash;
    private Image jonathan;
    private Image littleJonathan;
    private int backgroundXCoord;
    private int jDashXCoord;
    private int jonathanYCoord;
    private int lJonathanXCoord;

    public WelcomePanel() {
        stop = false;
        PRESSEDKEYS = new boolean[128];
        try {
            background = ImageIO.read(new File("src/Images/Background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            base = ImageIO.read(new File("src/Images/Base.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            jonathan = ImageIO.read(new File("src/Images/Jonathan.png")).getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            javametryDash = ImageIO.read(new File("src/Images/JavametryDash.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            littleJonathan = ImageIO.read(new File("src/Images/LittleJonathan.png")).getScaledInstance(128, 123, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        backgroundXCoord = 0;
        jDashXCoord = 1000;
        jonathanYCoord = 500;
        lJonathanXCoord = 1000;
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, backgroundXCoord, -20, null);
        backgroundXCoord--;

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (backgroundXCoord == -200) {
            g.drawImage(background, 2560, 0, null);
            backgroundXCoord = 0;
        }

        g.drawImage(jonathan, 50, jonathanYCoord, null);
        g.drawImage(javametryDash, jDashXCoord, 20, null);
        g.drawImage(littleJonathan, lJonathanXCoord, 580, null);
        g.drawImage(base, -300, 700, null);

        if (jDashXCoord > 400) {
            jDashXCoord--;
        } else {
            lJonathanXCoord--;
        }

        if (jDashXCoord == 400 && PRESSEDKEYS[32] && !stop) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (jonathanYCoord > 203) {
                jonathanYCoord -= 11;
            } else {
                jonathanYCoord = 500;
                stop = true;
            }
        }

        if (!PRESSEDKEYS[32]) {
            stop = false;
            jonathanYCoord = 500;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        PRESSEDKEYS[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PRESSEDKEYS[e.getKeyCode()] = false;
    }
}

// IDEA: ADD MULTIPLE SPRITE OPTIONS, NOT JUST JONATHAN