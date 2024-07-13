package BrickFrame.CircleFrame.circles;

import BrickFrame.CircleFrame.common.Interactable;
import BrickFrame.CircleFrame.common.MainCanvas;
import BrickFrame.CircleFrame.common.Sprite;

import java.awt.*;
import java.lang.annotation.Inherited;

public class Background implements Interactable {
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    @Override
    public void update (MainCanvas canvas, float deltaTime){
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render (MainCanvas canvas, Graphics g){
        canvas.setBackground(color);
    }
}

