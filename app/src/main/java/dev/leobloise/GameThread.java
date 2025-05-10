package dev.leobloise;
import dev.leobloise.entities.Moveable;

import java.awt.*;
import java.util.Collection;

public class GameThread extends Thread {
    private final Canvas canvas;
    private final Collection<Moveable> moveables;
    public GameThread(
            Canvas gameCanvas,
            Collection<Moveable> moveables
    ) {
        this.canvas = gameCanvas;
        this.moveables = moveables;
    }
    private synchronized void update() {
        moveables.forEach(Moveable::move);
    }
    private void render() {
        canvas.repaint();
    }
    private long getDrawInterval() {
        int FPS = 30;
        return 1000000000 / FPS;
    }
    private long waitUntil(long nextDrawInterval) {
        try {
            long remainingTime = nextDrawInterval - System.nanoTime();
            remainingTime = remainingTime/1000000;
            if (remainingTime < 0) remainingTime = 0;
            Thread.sleep(remainingTime);
            nextDrawInterval += getDrawInterval();
            return nextDrawInterval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void gameLoop() {
        long nextDrawInterval = getDrawInterval() + System.nanoTime();
        while (true) {
            update();
            render();
            nextDrawInterval = waitUntil(nextDrawInterval);
        }
    }
    @Override
    public void run() {
        gameLoop();
    }
}
