import javax.swing.*;

public class WelcomeFrame {
    private final WelcomePanel PANEL;

    public WelcomeFrame() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 480);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        // create and add panel
        PANEL = new WelcomePanel(frame);
        frame.add(PANEL);

        // display the frame
        frame.setVisible(true);

        // no thread needed here since we aren't doing animation for this frame/panel
    }
}