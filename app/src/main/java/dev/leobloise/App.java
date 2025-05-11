package dev.leobloise;

import dev.leobloise.builders.AssetsBuilder;
import dev.leobloise.builders.BirdBuilder;
import dev.leobloise.components.Bird;
import dev.leobloise.components.GameCanvas;
import dev.leobloise.windows.MainWindow;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        AssetsBuilder assetsBuilder = new AssetsBuilder();
        BirdBuilder birdBuilder = new BirdBuilder(assetsBuilder);
        Bird bird = birdBuilder.build((assetsBuilder.buildBackground().getWidth() / 2), (assetsBuilder.buildBackground().getHeight() / 2));
        GameCanvas gameCanvas = new GameCanvas(Arrays.asList(assetsBuilder.buildBackground(), bird));
        GameThread gameThread = new GameThread(
                gameCanvas,
                new GameMediatorImpl(gameCanvas, bird, assetsBuilder.buildBackground())
        );
        MainWindow mainWindow = new MainWindow(
                assetsBuilder.buildBackground().getDimension(),
                gameCanvas
        );
        assetsBuilder = null;
        birdBuilder = null;
        bird = null;
        mainWindow.display();
        System.gc();
        gameThread.start();
    }
}
