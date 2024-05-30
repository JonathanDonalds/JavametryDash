import javax.swing.*;

public class WelcomeFrame implements Runnable {
    private final WelcomePanel PANEL;

    public WelcomeFrame() {
        JFrame frame = new JFrame("Javametry Dash");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        frame.setResizable(false);
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