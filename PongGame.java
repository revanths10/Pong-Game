package Project;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PongGame extends JPanel implements KeyListener {

    private int player1Y = 250;
    private int player2Y = 250;
    private int ballX = 350;
    private int ballY = 250;
    private int ballSpeedX = -5;
    private int ballSpeedY = 5;

    public PongGame() {
        JFrame frame = new JFrame("Pong Game");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paint(Graphics g) {
        // draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 700, 500);

        // draw players
        g.setColor(Color.WHITE);
        g.fillRect(50, player1Y, 10, 50);
        g.fillRect(640, player2Y, 10, 50);

        // draw ball
        g.fillOval(ballX, ballY, 10, 10);

        // check for collision with player 1
        if (ballX <= 60 && ballY >= player1Y && ballY <= player1Y + 50) {
            ballSpeedX = -ballSpeedX;
        }

        // check for collision with player 2
        if (ballX >= 630 && ballY >= player2Y && ballY <= player2Y + 50) {
            ballSpeedX = -ballSpeedX;
        }

        // check for collision with top or bottom of screen
        if (ballY <= 0 || ballY >= 490) {
            ballSpeedY = -ballSpeedY;
        }

        // move ball
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // check for game over
        if (ballX <= 0 || ballX >= 690) {
            ballSpeedX = -ballSpeedX;
            ballX = 350;
            ballY = 250;
        }
    }

    public void keyPressed(KeyEvent e) {
        // move player 1 up
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player1Y -= 10;
        }
        // move player 1 down
        if (e.getKeyCode() == KeyEvent.VK_S) {
            player1Y += 10;
        }
        // move player 2 up
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player2Y -= 10;
        }
        // move player 2 down
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player2Y += 10;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new PongGame();
    }
}