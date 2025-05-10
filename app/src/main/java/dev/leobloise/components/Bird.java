package dev.leobloise.components;

import dev.leobloise.entities.Moveable;
import dev.leobloise.images.ImageAsset;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Bird implements Moveable {
    private int x = 0;
    private int y = 0;
    private final ImageAsset birdMidFlap;
    private final ImageAsset birdDownFlap;
    private final ImageAsset birdUpFlap;
    public Bird(
            ImageAsset birdUpFlap,
            ImageAsset birdMidFlap,
            ImageAsset birdDownFlap
    ) {
        this.birdDownFlap = birdDownFlap;
        this.birdMidFlap = birdMidFlap;
        this.birdUpFlap = birdUpFlap;
    }
    public void move() {
        y += 2;
    }
    @Override
    public void renderOn(Graphics g) {
        g.drawImage(birdMidFlap.read(), x, y, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
