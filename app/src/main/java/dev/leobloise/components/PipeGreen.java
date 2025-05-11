package dev.leobloise.components;

import dev.leobloise.entities.Moveable;
import dev.leobloise.images.ImageAsset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PipeGreen extends ImageAsset implements Moveable {
    private int x;
    private int y;
    public PipeGreen(int x, int y) {
        super("pipe-green.png");
        this.x = x;
        this.y = y;
    }
    public PipeGreen(BufferedImage image, int x, int y) {
        super(image);
        this.x = x;
        this.y = y;
    }
    @Override
    public void move() {
        x--;
     }
    @Override
    public void renderOn(Graphics canvas) {
        canvas.drawImage(read(), x, y, (Image img, int infoflags, int x, int y, int width, int height) -> false);
    }
    public void renderOn(Graphics canvas, int rotate) {
        canvas.drawImage(read(rotate), x, y, (Image img, int infoflags, int x, int y, int width, int height) -> false);
    }
    public int getX() {
        return x;
    }
}
