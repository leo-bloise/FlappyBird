package dev.leobloise.components;

import dev.leobloise.images.ImageAsset;

import java.awt.*;
import java.util.Collection;

public class GameCanvas extends Canvas {
    private final ImageAsset background;
    private final Collection<Renderable> renderables;
    private Image offscreenBuffer;
    public GameCanvas(
            ImageAsset background,
            Collection<Renderable> renderables
    ) {
        super();
        this.background = background;
        this.renderables = renderables;
    }
    private void drawContent() {
        if (offscreenBuffer == null) offscreenBuffer = createImage(getWidth(), getHeight());
        Graphics bufferGraphics = offscreenBuffer.getGraphics();
        bufferGraphics.drawImage(background.read(), 0, 0, this);
        renderables.forEach((Renderable re) -> re.renderOn(bufferGraphics));
    }
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    @Override
    public void paint(Graphics g) {
        drawContent();
        g.drawImage(offscreenBuffer, 0, 0, this);
        offscreenBuffer.flush();
    }
}
