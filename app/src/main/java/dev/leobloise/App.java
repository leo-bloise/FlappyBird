package dev.leobloise;

import dev.leobloise.builders.AssetsBuilder;
import dev.leobloise.builders.BirdBuilder;
import dev.leobloise.components.Bird;
import dev.leobloise.components.GameCanvas;
import dev.leobloise.components.PipeGreenFactory;
import dev.leobloise.windows.MainWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        AssetsBuilder assetsBuilder = new AssetsBuilder();
        PipeGreenFactory.create(assetsBuilder.buildBackground().getDimension());
        BirdBuilder birdBuilder = new BirdBuilder(assetsBuilder);
        Bird bird = birdBuilder.build((assetsBuilder.buildBackground().getWidth() / 2), (assetsBuilder.buildBackground().getHeight() / 2));
        GameCanvas gameCanvas = new GameCanvas(new ArrayList<>(
                Arrays.asList(assetsBuilder.buildBackground(), bird)
        ));
        GameThread gameThread = new GameThread(
                gameCanvas,
                new GameMediatorImpl(gameCanvas, bird, assetsBuilder.buildBackground())
        );
        MainWindow mainWindow = new MainWindow(
                assetsBuilder.buildBackground().getDimension(),
                gameCanvas
        );
        mainWindow.display();
        gameThread.start();
    }
}
