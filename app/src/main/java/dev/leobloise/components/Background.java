package dev.leobloise.components;

import dev.leobloise.entities.Renderable;
import dev.leobloise.images.ImageAsset;

import java.awt.*;

public class Background extends ImageAsset implements Renderable {
    private int x = 0;
    public Background(String filename) {
        super(filename);
    }
    @Override
    public void renderOn(Graphics canvas) {
        canvas.drawImage(read(), 0, 0, null);
    }
}
