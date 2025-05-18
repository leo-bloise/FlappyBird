package dev.leobloise;

import dev.leobloise.builders.AssetsBuilder;
import dev.leobloise.builders.BirdBuilder;
import dev.leobloise.components.*;
import dev.leobloise.entities.Renderable;
import dev.leobloise.windows.MainWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        AssetsBuilder assetsBuilder = AssetsBuilder.getInstance();
        PipeGreenFactory.create(assetsBuilder.buildBackground().getDimension());
        Score.init(assetsBuilder);
        Score score = new Score(0, assetsBuilder.buildBackground().getDimension());
        BirdBuilder birdBuilder = new BirdBuilder(assetsBuilder);
        Bird bird = birdBuilder.build((assetsBuilder.buildBackground().getWidth() / 2), (assetsBuilder.buildBackground().getHeight() / 2));
        Base base = assetsBuilder.buildBase(assetsBuilder.buildBackground().getHeight(), assetsBuilder.buildBackground().getWidth());
        GameCanvas gameCanvas = new GameCanvas(new ArrayList<>(
                Arrays.asList(assetsBuilder.buildBackground(), bird)
        ), score, base);
        GameThread gameThread = new GameThread(
                gameCanvas,
                new GameMediatorImpl(gameCanvas, bird, score, base)
        );
        MainWindow mainWindow = new MainWindow(
                assetsBuilder.buildBackground().getDimension(),
                gameCanvas
        );
        mainWindow.display();
        gameThread.start();
    }
}
