package dev.leobloise.windows;

import dev.leobloise.images.ImageAsset;
import dev.leobloise.windows.listeners.ClosingWindowListner;

import java.awt.*;

public class MainWindow extends Frame {
    private final ImageAsset background;
    public MainWindow(ImageAsset background) {
        super("Flappy Bird");
        this.background = background;
        setUp();
        setUpListeners();
    }
    private void setUp() {
        setSize(800, 800);
    }
    private void setUpListeners() {
        addWindowListener(new ClosingWindowListner(true));
    }
    public void display() {
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(
                background.read(),
                0,
                0,
                getWidth(),
                getHeight(),
                this
        );
    }
}
