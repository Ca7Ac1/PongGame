import java.io.InterruptedIOException;

import javax.swing.JFrame;

public class Game {

    private static JFrame frame;
    private static Pong pong;

    public Game() {
        frame = new JFrame("Pong");
        pong = new Pong();
        
        initializeFrame();
    }

    private static void initializeFrame() {
        pong.restart();
        frame.add(pong);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void restart() {
        frame.dispose();
        frame = null;
        frame = new JFrame();

        initializeFrame();
    }

    public static void end() {
        frame.dispose();
    }
}