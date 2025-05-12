package dev.leobloise.components;

import dev.leobloise.builders.AssetsBuilder;
import dev.leobloise.entities.GameAudio;
import dev.leobloise.entities.Renderable;
import dev.leobloise.images.ImageAsset;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Score implements Renderable {
    private int score;
    private final Dimension screenDimension;
    private GameAudio gameAudio;
    private final static Map<Integer, ImageAsset> maps = new HashMap<>();
    public static void init(AssetsBuilder assetsBuilder) {
        if (!maps.isEmpty()) return;
        maps.put(0, assetsBuilder.getScore0Number());
        maps.put(1, assetsBuilder.getScore1Number());
        maps.put(2, assetsBuilder.getScore2Number());
        maps.put(3, assetsBuilder.getScore3Number());
        maps.put(4, assetsBuilder.getScore4Number());
        maps.put(5, assetsBuilder.getScore5Number());
        maps.put(6, assetsBuilder.getScore6Number());
        maps.put(7, assetsBuilder.getScore7Number());
        maps.put(8, assetsBuilder.getScore8Number());
        maps.put(9, assetsBuilder.getScore9Number());
    }
    public Score(int score, Dimension screenDimension) {
        this.score = score;
        this.screenDimension = screenDimension;
        loadAudio();
    }
    private void loadAudio() {
        GameAudio gameAudio = new GameAudio("point.wav");
        gameAudio.read();
        this.gameAudio = gameAudio;
    }
    public void increment() {
        score++;
        gameAudio.play();
    }
    @Override
    public void renderOn(Graphics canvas) {
        String scoreStr = String.valueOf(score);
        int digitCount = scoreStr.length();
        int totalWidth = 0;
        int[] widths = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            int digit = scoreStr.charAt(i) - '0';
            ImageAsset asset = maps.get(digit);
            widths[i] = asset.getWidth();
            totalWidth += widths[i];
        }
        int startX = (screenDimension.width / 2) - (totalWidth / 2);
        for (int i = 0; i < digitCount; i++) {
            int digit = scoreStr.charAt(i) - '0';
            ImageAsset asset = maps.get(digit);
            canvas.drawImage(asset.read(), startX, 50, null);
            startX += widths[i];
        }
    }
}
