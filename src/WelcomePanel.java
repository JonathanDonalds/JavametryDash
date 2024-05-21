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
    private int yCoord;

    public WelcomePanel(JFrame frame) {
        FRAME = frame;
        try {
            BACKGROUND = ImageIO.read(new File("src/Images/Background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        yCoord = 0;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(BACKGROUND, 0, yCoord, null);
        yCoord += 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}