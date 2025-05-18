package dev.leobloise.components;

import dev.leobloise.entities.Moveable;
import dev.leobloise.entities.Renderable;
import dev.leobloise.images.ImageAsset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Base extends ImageAsset implements Renderable, Moveable {
    private final int height;
    private final int screenWidth;
    private int x = 0;
    private int y;
    public Base(int screenHeight, int screenWidth) {
        super("base.png");
        this.height = screenHeight;
        this.screenWidth = screenWidth;
        this.initializeY();
    }
    private void initializeY() {
        BufferedImage bufferedImage = read();
        this.y = height - bufferedImage.getHeight();
    }
    @Override
    public void renderOn(Graphics canvas) {
        if(x < (-1*screenWidth)) {
            x = 0;
        }
        int newX = getWidth() + x;
        canvas.drawImage(read(), x, y, null);
        if(newX < screenWidth) {
            canvas.drawImage(read(), newX, y, null);
        }
    }
    @Override
    public void move() {
        x--;
    }
}
