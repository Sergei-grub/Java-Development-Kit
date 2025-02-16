package BrickFrame.CircleFrame.circles;

import BrickFrame.CircleFrame.common.CanvasRepaintListener;
import CircleFrame.Background;
import CircleFrame.Ball;
import CircleFrame.MainCanvas;
import CircleFrame.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame implements
        CanvasRepaintListener, MouseListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Sprite[] sprites = new Sprite[16];


    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        CanvasRepaintListener canvas = new CanvasRepaintListener() {
            @Override
            public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {

            }

            @Override
            public void onDrawFrame(BrickFrame.CircleFrame.common.MainCanvas mainCanvas, Graphics g, float deltaTime) {

            }
        };
        add((Component) canvas);
        ((Component) canvas).addMouseListener(this);



        setVisible(true);

        sprites[0] = new Background();
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);

    }

    @Override
    public void onDrawFrame(BrickFrame.CircleFrame.common.MainCanvas mainCanvas, Graphics g, float deltaTime) {

    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (Sprite sprite : sprites) {
            sprite.update(canvas, deltaTime);
        }

    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }

    }

    public static void main(String[] args) {
        new MainWindow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Clicked");

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
