import javax.swing.*;

public class Frame implements Runnable {
    private final Panel PANEL;

    public Frame() {
        JFrame frame = new JFrame("Javametry Dash");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        PANEL = new Panel();
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