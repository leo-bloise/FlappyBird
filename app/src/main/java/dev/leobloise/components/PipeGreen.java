package dev.leobloise.components;

import dev.leobloise.entities.Moveable;
import dev.leobloise.images.ImageAsset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PipeGreen extends ImageAsset implements Moveable {
    private int x;
    private int y;
    private boolean passed;
    private CollidablePipeArea collidablePipeArea;
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
    public boolean getPassed() {
        return passed;
    }
    public void setPassed(boolean passed) {
        this.passed = passed;
    }
    public void setCollidablePipeArea(CollidablePipeArea collidablePipeArea) {
        this.collidablePipeArea = collidablePipeArea;
    }
    public CollidablePipeArea getCollidablePipeArea() {
        return this.collidablePipeArea;
    }
    @Override
    public void move() {
        x--;
        if (collidablePipeArea != null) {
            setCollidablePipeArea(new CollidablePipeArea(
                    x,
                    collidablePipeArea.yu(),
                    x,
                    collidablePipeArea.yb(),
                    collidablePipeArea.hu(),
                    collidablePipeArea.hb()
            ));
        }
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
