package dev.leobloise.components;

import dev.leobloise.entities.Moveable;
import dev.leobloise.images.ImageAsset;

import java.awt.*;

public class Background extends ImageAsset implements Moveable {
    private int x = 0;
    public Background(String filename) {
        super(filename);
    }
    @Override
    public void renderOn(Graphics canvas) {
        if ((-1*x) == getWidth()) {
             x = 0;
        }
        int newX = x + getWidth();
        canvas.drawImage(read(), x, 0, (Image img, int infoflags, int x, int y, int width, int height) -> false);
        if (newX < getWidth()) {
            canvas.drawImage(read(), newX, 0, (Image img, int infoflags, int x, int y, int width, int height) -> false);
        }
    }
    @Override
    public void move() {
        x -= 2;
    }
}
