import java.awt.*;

public class Ball {

    private static final int BALL_WIDTH = 25;
    private static final int BALL_HEIGHT = 25;

    private int xCor;
    private int yCor;

    private int verticalMovement;
    private int horizontalMovement;;

    public Ball() {
        xCor = Pong.getBoardWidth() / 2;
        yCor = Pong.getBoardHeight() / 2;

        verticalMovement = 3;
        horizontalMovement = 4;
    }

    private void checkWin() {
        if (xCor < 0) {
            Pong.increaseRScore();
            xCor = Pong.getBoardWidth() / 2;
            yCor = Pong.getBoardHeight() / 2;
        }

        if (xCor > Pong.getBoardWidth() - BALL_WIDTH) {
            Pong.increaseLScore();
            xCor = Pong.getBoardWidth() / 2;
            yCor = Pong.getBoardHeight() / 2;
        }
    }

    private void bounce() {
        if (Pong.getLPaddle().getBounds().intersects(getBounds())) {
            horizontalMovement = 4;
            verticalMovement = verticalMovement + Pong.getLPaddle().getBallShift();
        }

        if (Pong.getRPaddle().getBounds().intersects(getBounds())) {
            horizontalMovement = -4;
            verticalMovement = verticalMovement + Pong.getRPaddle().getBallShift();
        }

        if (yCor <= 0 || yCor >= (Pong.getBoardHeight() - BALL_HEIGHT)) {
            verticalMovement = -verticalMovement;
        }
    }

    public void update() {
        xCor += horizontalMovement;
        yCor += verticalMovement;

        bounce();
        checkWin();
    }

    public Rectangle getBounds() {
        return new Rectangle(xCor, yCor, BALL_WIDTH, BALL_HEIGHT);
    }

    public void draw(Graphics g) {
        g.fillRect(xCor, yCor, BALL_WIDTH, BALL_HEIGHT);
    }

}