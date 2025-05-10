package dev.leobloise;

import dev.leobloise.images.Background;
import dev.leobloise.windows.MainWindow;

public class App {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(
                new Background("background.png")
        );
        mainWindow.display();
    }
}
