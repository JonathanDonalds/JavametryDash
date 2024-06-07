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
    private boolean goingUp;
    private boolean stop;
    private final boolean[] PRESSEDKEYS;
    private Image background;
    private Image base;
    private Image javametryDash;
    private Image jonathanImg;
    private Image littleJonathanImg;
    private int backgroundXCoord;
    private int jDashXCoord;
    private int jonathanYCoord;
    private int lJonathanXCoord;
    private int time1;
    private int time2;
    private Sprite jonathan;
    private Sprite lJonathan;


    public WelcomePanel() {
        goingUp = true;
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
            jonathan = new Sprite(ImageIO.read(new File("src/Images/Jonathan.png")), "Jonathan");
            jonathanImg = jonathan.getImage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            javametryDash = ImageIO.read(new File("src/Images/JavametryDash.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            lJonathan = new Sprite(ImageIO.read(new File("src/Images/LittleJonathan.png")), "Little Jonathan");
            littleJonathanImg = lJonathan.getImage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        backgroundXCoord = 0;
        jDashXCoord = 1000;
        jonathanYCoord = 500;
        lJonathanXCoord = 1000;
        time1 = 0;
        time2 = 0;
        Timer timer = new Timer(80, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (time1 < 6) {
            g.drawImage(background, backgroundXCoord, -20, null);
            backgroundXCoord--;
            if (backgroundXCoord == -200) {
                g.drawImage(background, 2560, 0, null);
                backgroundXCoord = 0;
            }
            time1 = 0;
        }
        g.drawImage(jonathanImg, 50, jonathanYCoord, null);
        g.drawImage(javametryDash, jDashXCoord, 20, null);
        g.drawImage(littleJonathanImg, lJonathanXCoord, 610, null);
        g.drawImage(base, -300, 700, null);

        if (jDashXCoord > 400) {
            jDashXCoord--;
        } else {
            lJonathanXCoord--;
            jonathan.setXCoord(lJonathanXCoord);
        }

        if (lJonathanXCoord < -100) {
            lJonathanXCoord = 1600;
            jonathan.setXCoord(lJonathanXCoord);
        }

        if (jDashXCoord == 400 && PRESSEDKEYS[32] && !stop) {
            if (time2 >= 0) {
                if (jonathanYCoord > 203 && goingUp) {
                    jonathanYCoord -= 10;
                    jonathan.setYCoord(jonathanYCoord);
                } else if (jonathanYCoord != 500) {
                    goingUp = false;
                    jonathanYCoord += 1;
                    jonathan.setYCoord(jonathanYCoord);
                }
                time2 = 0;
            }
        }

        if (!PRESSEDKEYS[32]) {
            goingUp = true;
            stop = false;
            jonathanYCoord = 500;
            jonathan.setYCoord(jonathanYCoord);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            time1++;
            time2++;
        }
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