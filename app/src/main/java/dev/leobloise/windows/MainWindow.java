package dev.leobloise.windows;

import dev.leobloise.windows.listeners.ClosingWindowListner;

import java.awt.*;

public class MainWindow extends Frame {
    private final Canvas canvas;
    private final Dimension dimension;
    public MainWindow(
            Dimension dimension,
            Canvas gameCanvas
    ) {
        super("Flappy Bird");
        this.canvas = gameCanvas;
        this.dimension = dimension;
        setUp();
        setUpListeners();
    }
    private void setUp() {
        setSize(dimension);
        add(canvas);
    }
    private void setUpListeners() {
        addWindowListener(new ClosingWindowListner(true));
    }
    public void display() {
        setVisible(true);
    }
}
