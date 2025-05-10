package dev.leobloise;

import dev.leobloise.components.Bird;
import dev.leobloise.components.GameCanvas;
import dev.leobloise.images.ImageAsset;
import dev.leobloise.windows.MainWindow;
import java.util.Collections;

public class App {
    private static Bird createBird(AssetsBuilder assetsBuilder) {
        BirdBuilder birdBuilder = new BirdBuilder(assetsBuilder);
        Bird bird = birdBuilder.build();
        birdBuilder = null;
        return bird;
    }
    public static void main(String[] args) {
        AssetsBuilder assetsBuilder = new AssetsBuilder();
        Bird bird = createBird(assetsBuilder);
        ImageAsset background = assetsBuilder.buildBackground();
        GameCanvas gameCanvas = new GameCanvas(background, Collections.singletonList(bird));
        GameThread gameThread = new GameThread(
                bird,
                gameCanvas
        );
        MainWindow mainWindow = new MainWindow(
                background.getDimension(),
                gameCanvas
        );
        assetsBuilder = null;
        mainWindow.display();
        System.gc();
        gameThread.start();
    }
}
