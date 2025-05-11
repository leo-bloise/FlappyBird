package dev.leobloise.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Assets {
    public static BufferedImage rotate(BufferedImage image, int degree) {
        BufferedImage copy = new BufferedImage(
                image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D graphics2D = copy.createGraphics();
        graphics2D.rotate(Math.toRadians(degree), (double) image.getWidth() / 2, (double) image.getHeight() / 2);
        graphics2D.drawImage(image, null, 0, 0);
        return copy;
    }
}
