import javax.swing.*;

public class WelcomeFrame {
    private final WelcomePanel PANEL;

    public WelcomeFrame() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 480);
        frame.setLocationRelativeTo(null);

        PANEL = new WelcomePanel(frame);
        frame.add(PANEL);

        frame.setVisible(true);
    }
}