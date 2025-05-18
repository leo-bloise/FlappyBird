// TODO: Check removing the buffered image from the method.
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
    /**
     * Determines the lowest y position where we can begin rendering the pipe
     * @return int
     */
    private int getMaxDown() { // For the current background, it must be 460
        return (int) Math.floor(screenDimension.getHeight() * 0.75);
    }
    /**
     * Determines the biggest y position where we can begin rendering the pipe
     * @return int
     */
    private int getMaxUp() { // For the current background, it must be 200
        return (int) Math.floor(screenDimension.getHeight() * 0.390625);
    }
    private int getRandomNumber() {
        int maxDown = getMaxDown();
        int maxUp = getMaxUp();
        return (int) ((Math.random() * (maxUp - maxDown)) + maxDown);
    }
    private BufferedImage merge(PipeGreen upPipe, PipeGreen downPipe) {
        BufferedImage result = new BufferedImage(screenDimension.width, screenDimension.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = result.createGraphics();
        upPipe.renderOn(graphics2D, 180);
        downPipe.renderOn(graphics2D);
        graphics2D.dispose();
        return result;
    }
    public PipeGreen create() {
        int downY = getRandomNumber();
        PipeGreen downPipe = new PipeGreen(0, downY);
        int upPipeYStart = ((downPipe.getHeight() - downY) * -1) -150;
        PipeGreen upPipe = new PipeGreen(0, upPipeYStart);
        CollidablePipeArea collidablePipeArea = new CollidablePipeArea(
                screenDimension.width,
                0,
                screenDimension.width,
                downY,
                downY - 150,
                screenDimension.height - downY
        );
        PipeGreen pipeGreen = new PipeGreen(merge(upPipe, downPipe), screenDimension.width, 0);
        pipeGreen.setCollidablePipeArea(collidablePipeArea);
        return pipeGreen;
    }
}
