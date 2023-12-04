package org.example.movingObjects.common;

import java.awt.*;

public interface CanvasRepaintListerner {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
