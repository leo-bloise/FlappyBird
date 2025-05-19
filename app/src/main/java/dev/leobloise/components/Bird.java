package dev.leobloise.components;

import dev.leobloise.entities.Moveable;
import dev.leobloise.images.ImageAsset;
import dev.leobloise.utils.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird implements Moveable {
    private int x;
    private int y;
    private final static int SPEED = -10;
    private int speed = SPEED;
    private final ImageAsset birdSprite;
    private int fps = 0;
    private int currFrame = 0;
    public Bird(
            ImageAsset birdSprite,
            int x,
            int y
    ) {
        this.birdSprite = birdSprite;
        this.x = x;
        this.y = y;
    }
    public void move() {
        speed = SPEED;
        y += speed;
        y = Math.max(0, y);
    }
    public void applyGravity() {
        speed += 1;
        speed = Math.min(10, speed);
        y += speed;
    }
    public int getWidth() {
        return birdSprite.getWidth();
    }
    public int getHeight() {
        return birdSprite.getHeight() / 3;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    private BufferedImage getBufferedImage() {
        return new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    }
    private BufferedImage rotateIfNeeded(BufferedImage bufferedImage) {
        int degree = -45;
        if(speed < 0) {
            return Assets.rotate(bufferedImage, degree);
        }
        if(speed >= 2) {
            degree += speed * 11;
        }
        return Assets.rotate(bufferedImage, degree);
    }
    @Override
    public void renderOn(Graphics g) {
        BufferedImage img = birdSprite.read();
        BufferedImage bufferedImage = getBufferedImage();
        Graphics bufferG = bufferedImage.getGraphics();
        bufferG.drawImage(img, 0, 0, getWidth(), getHeight(), 0, currFrame * getHeight(), getWidth(), getHeight() * (currFrame + 1), null);
        g.drawImage(rotateIfNeeded(bufferedImage), x, y, null);
        if (fps < 6) {
            fps++;
            return;
        }
        if(currFrame < 2) {
            currFrame++;
            fps = 0;
            return;
        }
        currFrame = 0;
        fps = 0;
    }
}
