import javax.swing.*;

public class WelcomeFrame implements Runnable {
    private final WelcomePanel PANEL;

    public WelcomeFrame() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2560, 1600);
        frame.setLocationRelativeTo(null);

        PANEL = new WelcomePanel();
        frame.add(PANEL);

        frame.setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            PANEL.repaint();
        }
    }
}