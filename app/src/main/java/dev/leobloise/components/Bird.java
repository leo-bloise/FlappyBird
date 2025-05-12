package dev.leobloise.components;

import dev.leobloise.entities.Moveable;
import dev.leobloise.images.ImageAsset;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Bird implements Moveable {
    private int x;
    private int y;
    private final ImageAsset birdMidFlap;
    private final ImageAsset birdDownFlap;
    private final ImageAsset birdUpFlap;
    private int speed = -10;
    public Bird(
            ImageAsset birdUpFlap,
            ImageAsset birdMidFlap,
            ImageAsset birdDownFlap,
            int x,
            int y
    ) {
        this.birdDownFlap = birdDownFlap;
        this.birdMidFlap = birdMidFlap;
        this.birdUpFlap = birdUpFlap;
        this.x = x;
        this.y = y;
    }
    public void move() {
        speed = -10;
        y += speed;
        y = Math.max(y, 1);
    }
    public void applyGravity() {
        speed += 1;
        speed = Math.min(10, speed);
        y += speed;
    }
    public int getWidth() {
        return birdDownFlap.getWidth();
    }
    public int getHeight() {
        return birdDownFlap.getHeight();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public void renderOn(Graphics g) {
        BufferedImage img = birdUpFlap.read(-30);
        if (speed == 0) {
            img = birdMidFlap.read();
        } else if (speed > 0) {
            img = birdDownFlap.read(30);
        }
        g.drawImage(img, x, y, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
