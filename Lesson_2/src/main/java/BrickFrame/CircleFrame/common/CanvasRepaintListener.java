package BrickFrame.CircleFrame.common;

import CircleFrame.MainCanvas;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);


    void onDrawFrame(BrickFrame.CircleFrame.common.MainCanvas mainCanvas, Graphics g, float deltaTime);
}
