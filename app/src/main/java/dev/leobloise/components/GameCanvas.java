package dev.leobloise.components;

import dev.leobloise.entities.Renderable;

import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends Canvas {
    private final ArrayList<Renderable> renderables;
    private final Score score;
    private Image offscreenBuffer;
    public GameCanvas(
            ArrayList<Renderable> renderables,
            Score score
    ) {
        super();
        this.renderables = renderables;
        this.score = score;
    }
    public void addToCanvas(Renderable renderable) {
        renderables.add(renderable);
    }
    private void drawContent() {
        if (offscreenBuffer == null) offscreenBuffer = createImage(getWidth(), getHeight());
        Graphics bufferGraphics = offscreenBuffer.getGraphics();
        renderables.forEach((Renderable re) -> re.renderOn(bufferGraphics));
        score.renderOn(bufferGraphics);
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
