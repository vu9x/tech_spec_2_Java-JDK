package org.example.movingObjects.bricks;

import org.example.movingObjects.common.MainCanvas;
import org.example.movingObjects.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Bricks extends Sprite {
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    Bricks(){
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);

    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if(getLeft() < canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if(getRight() > canvas.getRight()){
            setRight(canvas.getRight());
            vX = -vX;
        }
        if(getTop() < canvas.getTop()){
            setTop(canvas.getTop());
            vY = -vY;
        }
        if(getBottom() > canvas.getBottom()){
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillRect((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }

}
