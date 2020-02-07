import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Pong extends JPanel implements ActionListener {

    private static final int BOARD_WIDTH = 700;
    private static final int BOARD_HEIGHT = 700;
    private static final int OPTIMAL_DELAY = 5;

    private static Paddle lPaddle;
    private static Paddle rPaddle;
    private static Ball ball;

    private Timer timer;
    private static int delay = 40;

    private static int lScore;
    private static int rScore;

    private Font stringFont;

    public Pong() {
        lPaddle = new Paddle(Paddle.LEFT);
        rPaddle = new Paddle(Paddle.RIGHT);
        ball = new Ball();

        lScore = 0;
        rScore = 0;

        stringFont = new Font("TimesNewRoman", Font.PLAIN, 25);

        timer = new Timer(delay, this);

        timer.start();

        addKeyListener(new KeyChecker());

        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.setFont(stringFont);

        g.drawString(lScore + " : " + rScore, (BOARD_WIDTH / 2) - 8, 20);
        lPaddle.draw(g);
        rPaddle.draw(g);
        ball.draw(g);

        Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lPaddle.update();
        rPaddle.update();
        ball.update();

        if (delay > OPTIMAL_DELAY) {
            delay -= .1;
            timer.setDelay(delay);
        }

        repaint();

    }

    public void restart() {
        lScore = 0;
        rScore = 0;
        ball = new Ball();

        timer.restart();

    }

    public static int getBoardWidth() {
        return BOARD_WIDTH;
    }

    public static int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    public static Paddle getLPaddle() {
        return lPaddle;
    }

    public static Paddle getRPaddle() {
        return rPaddle;
    }

    public static void increaseLScore() {
        lScore++;
        if (lScore == 10) {
            if (JOptionPane.showConfirmDialog(null, "Player 1 wins. Would you like to restart?") == JOptionPane.YES_OPTION) {
                Game.restart();
            } else {
                Game.end();
            }
        }
    }

    public static void increaseRScore() {
        rScore++;
        if (rScore == 10) {
            if (JOptionPane.showConfirmDialog(null, "Player 1 wins. Would you like to restart?") == JOptionPane.YES_OPTION) {
                Game.restart();
            } else {
                Game.end();
            }
        }
    }

    public static Ball getBall() {
        return ball;
    }
}
