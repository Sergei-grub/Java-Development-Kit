package BrickFrame.CircleFrame.circles;

import BrickFrame.CircleFrame.common.MainCanvas;
import BrickFrame.CircleFrame.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {
    private static final Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;



    public Ball() {

        halfHeight = 10 + (float) (Math.random() * 30f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 100f);
        vY = 100f + (float) (Math.random() * 100f);
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX = -vX;
        }

        if (getRight() > canvas.getRight()){
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()){
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()){
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    public void render(MainCanvas canvas, Graphics g){
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }
}
