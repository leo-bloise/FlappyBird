package dev.leobloise.components;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PipeGreenFactory {
    private final Dimension screenDimension;
    private static PipeGreenFactory singleton;
    public static PipeGreenFactory create(Dimension screenDimension) {
        if (singleton != null) return singleton;
        singleton = new PipeGreenFactory(screenDimension);
        return singleton;
    }
    public static PipeGreenFactory getInstance() {
        return singleton;
    }
    private PipeGreenFactory(Dimension screen) {
        this.screenDimension = screen;
    }
    private double getMaxDown() {
        return screenDimension.getHeight() * 0.78;
    }
    private double getMaxUp() {
        return screenDimension.getHeight() * 0.38;
    }
    private int getRandomNumber() {
        return (int) ((Math.random() * (getMaxDown() - getMaxUp())) + getMaxUp());
    }
    private BufferedImage merge(PipeGreen upPipe, PipeGreen downPipe) {
        // #TO-DO: Check removing the buffered image from the method.
        BufferedImage result = new BufferedImage(screenDimension.width, screenDimension.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = result.createGraphics();
        upPipe.renderOn(graphics2D, -180);
        downPipe.renderOn(graphics2D);
        graphics2D.dispose();
        return result;
    }
    public PipeGreen create() {
        int downY = getRandomNumber();
        PipeGreen downPipe = new PipeGreen(0, downY);
        PipeGreen upPipe = new PipeGreen(0, ((downPipe.getHeight() - downY) * -1) -150);
        return new PipeGreen(merge(upPipe, downPipe), screenDimension.width, 0);
    }
}
