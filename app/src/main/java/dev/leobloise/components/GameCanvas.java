package dev.leobloise.components;

import dev.leobloise.images.ImageAsset;

import java.awt.*;

public class GameCanvas extends Canvas {
    private final ImageAsset background;
    public GameCanvas(ImageAsset background) {
        super();
        this.background = background;
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(background.read(), 0, 0, this);
    }
}
