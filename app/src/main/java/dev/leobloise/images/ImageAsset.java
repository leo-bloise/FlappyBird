package dev.leobloise.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class ImageAsset {
    private final String filename;
    private final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    private BufferedImage image = null;
    public ImageAsset(String filename) {
        this.filename = filename;
    }
    public BufferedImage read() {
        if (image != null) return image;
        try(InputStream imageInputStream = classLoader.getResourceAsStream(filename);) {
            if (imageInputStream == null) throw new RuntimeException(
                    String.format("Image %s was not found", filename)
            );
            image = ImageIO.read(imageInputStream);
            return image;
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
    @Override
    public String toString() {
        return filename;
    }
    public int getWidth() {
        if (image == null) read();
        return image.getWidth();
    }
    public int getHeight() {
        if (image == null) read();
        return image.getHeight();
    }
}
