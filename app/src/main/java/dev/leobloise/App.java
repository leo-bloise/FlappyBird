package dev.leobloise;

import dev.leobloise.components.GameCanvas;
import dev.leobloise.images.Background;
import dev.leobloise.windows.MainWindow;

public class App {
    public static void main(String[] args) {
        Background background = new Background("background.png");
        GameCanvas gameCanvas = new GameCanvas(background);
        MainWindow mainWindow = new MainWindow(
                background.getDimension(),
                gameCanvas
        );
        mainWindow.display();
    }
}
