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
    private JFrame FRAME;
    private int move;
    private int xCoord;
    private Timer time;

    public WelcomePanel(JFrame frame) {
        FRAME = frame;
        try {
            BACKGROUND = ImageIO.read(new File("src/Images/Background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        xCoord = 0;
        time = new Timer(7, this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BACKGROUND, xCoord, 0, null);
        xCoord++;
        if (xCoord == 10) {
            xCoord = 0;
            g.drawImage(BACKGROUND, xCoord, 0, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}