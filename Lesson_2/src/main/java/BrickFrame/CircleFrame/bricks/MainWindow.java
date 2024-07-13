package BrickFrame.CircleFrame.bricks;

import BrickFrame.CircleFrame.circles.Background;
import BrickFrame.CircleFrame.circles.Ball;
import BrickFrame.CircleFrame.common.CanvasRepaintListener;
import BrickFrame.CircleFrame.common.MainCanvas;
import BrickFrame.CircleFrame.common.Sprite;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Sprite[] sprites = new Sprite[16];


    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        setVisible(true);

//        sprites[0] = new Background();
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

//    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
//        update(canvas, deltaTime);
//        render(canvas, g);
//    }

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
    public void onDrawFrame(CircleFrame.MainCanvas canvas, Graphics g, float deltaTime) {
//        update(canvas, deltaTime);
//        render(canvas, g);
    }

    @Override
    public void onDrawFrame(MainCanvas mainCanvas, Graphics g, float deltaTime) {

    }
}
