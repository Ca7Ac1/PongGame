import java.awt.*;

public class Paddle {
    
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private static final int WIDTH = 15;
    private static final int HEIGHT = 80;

    private int xCor;
    private int yCor;

    private int yShift;
    private int yBallShift;

    public Paddle(int side) {
        if (side == 0) {
            xCor = 0;
        } else {
            xCor = Pong.getBoardWidth() - WIDTH;
        }

        yCor = Pong.getBoardHeight() / 2;
    }

    public void update() {
        if (yCor > 0 && yCor < Pong.getBoardHeight() - HEIGHT) {
            yCor += yShift;
        }

        if (yCor <= 0) {
            yCor += 1 - yCor;;
        }

        if (yCor >= Pong.getBoardHeight() - HEIGHT) {
            yCor -= yCor - (Pong.getBoardHeight() - HEIGHT - 1);
        }
    }

    public void goUp() { 
        yShift = -10;
        yBallShift = -1;
    }

    public void goDown() {
        yShift = 10;
        yBallShift = 1;
    }

    public void stop() {
        yShift = 0;
        yBallShift = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(xCor, yCor, WIDTH, HEIGHT);
    }

    public int getBallShift() {
        return yBallShift;
    }
    public void draw(Graphics g) {
        g.fillRect(xCor, yCor, WIDTH, HEIGHT);
    }

}