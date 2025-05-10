package dev.leobloise;

import dev.leobloise.builders.AssetsBuilder;
import dev.leobloise.builders.BirdBuilder;
import dev.leobloise.components.GameCanvas;
import dev.leobloise.windows.MainWindow;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        AssetsBuilder assetsBuilder = new AssetsBuilder();
        BirdBuilder birdBuilder = new BirdBuilder(assetsBuilder);
        GameCanvas gameCanvas = new GameCanvas(Arrays.asList(assetsBuilder.buildBackground(), birdBuilder.build()));
        GameThread gameThread = new GameThread(
                gameCanvas,
                Arrays.asList(assetsBuilder.buildBackground(), birdBuilder.build())
        );
        MainWindow mainWindow = new MainWindow(
                assetsBuilder.buildBackground().getDimension(),
                gameCanvas
        );
        assetsBuilder = null;
        birdBuilder = null;
        mainWindow.display();
        System.gc();
        gameThread.start();
    }
}
