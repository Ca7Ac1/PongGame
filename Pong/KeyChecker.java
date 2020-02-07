import java.awt.event.*;

public class KeyChecker implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            Pong.getLPaddle().goUp();
        }

        if (key == KeyEvent.VK_S) {
            Pong.getLPaddle().goDown();
        }

        if (key == KeyEvent.VK_UP) {
            Pong.getRPaddle().goUp();
        }

        if (key == KeyEvent.VK_DOWN) {
            Pong.getRPaddle().goDown();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            Pong.getLPaddle().stop();
        }

        if (key == KeyEvent.VK_S) {
            Pong.getLPaddle().stop();
        }

        if (key == KeyEvent.VK_UP) {
            Pong.getRPaddle().stop();
        }

        if (key == KeyEvent.VK_DOWN) {
            Pong.getRPaddle().stop();
        }

    }
}