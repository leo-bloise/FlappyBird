package dev.leobloise.builders;

import dev.leobloise.components.Background;
import dev.leobloise.components.Base;
import dev.leobloise.images.*;

public class AssetsBuilder {
    private static AssetsBuilder instance;
    public static AssetsBuilder getInstance() {
        if (instance == null) instance = new AssetsBuilder();
        return instance;
    }
    private Base base;
    private Background background;
    private ImageAsset birdMidFlap;
    private ImageAsset birdDownFlap;
    private ImageAsset birdUpFlap;
    private ImageAsset score0Number;
    private ImageAsset score1Number;
    private ImageAsset score2Number;
    private ImageAsset score3Number;
    private ImageAsset score4Number;
    private ImageAsset score5Number;
    private ImageAsset score6Number;
    private ImageAsset score7Number;
    private ImageAsset score8Number;
    private ImageAsset score9Number;
    private AssetsBuilder() {}
    public Base buildBase(int screenHeight, int screenWidth) {
        if(base!=null) return base;
        base = new Base(screenHeight, screenWidth);
        return base;
    }
    public ImageAsset getScore0Number() {
        if (score0Number != null) return score0Number;
        score0Number = new ScoreDigit("0.png");
        return score0Number;
    }
    public ImageAsset getScore1Number() {
        if (score1Number != null) return score1Number;
        score1Number = new ScoreDigit("1.png");
        return score1Number;
    }
    public ImageAsset getScore2Number() {
        if (score2Number != null) return score2Number;
        score2Number = new ScoreDigit("2.png");
        return score2Number;
    }
    public ImageAsset getScore3Number() {
        if (score3Number != null) return score3Number;
        score3Number = new ScoreDigit("3.png");
        return score3Number;
    }
    public ImageAsset getScore4Number() {
        if (score4Number != null) return score4Number;
        score4Number = new ScoreDigit("4.png");
        return score4Number;
    }
    public ImageAsset getScore5Number() {
        if (score5Number != null) return score5Number;
        score5Number = new ScoreDigit("5.png");
        return score5Number;
    }
    public ImageAsset getScore6Number() {
        if (score6Number != null) return score6Number;
        score6Number = new ScoreDigit("6.png");
        return score6Number;
    }
    public ImageAsset getScore7Number() {
        if (score7Number != null) return score7Number;
        score7Number = new ScoreDigit("7.png");
        return score7Number;
    }
    public ImageAsset getScore8Number() {
        if (score8Number != null) return score8Number;
        score8Number = new ScoreDigit("8.png");
        return score8Number;
    }
    public ImageAsset getScore9Number() {
        if (score9Number != null) return score9Number;
        score9Number = new ScoreDigit("9.png");
        return score9Number;
    }
    public Background buildBackground() {
        if (background != null) return background;
        background = new Background("background.png");
        return background;
    }
    public ImageAsset birdMidFlap() {
        if (birdMidFlap != null) return birdMidFlap;
        birdMidFlap = new BirdMidFlap("bird-midflap.png");
        return birdMidFlap;
    }
    public ImageAsset birdDownFlap() {
        if (birdDownFlap != null) return birdDownFlap;
        birdDownFlap = new BirdDownFlap("bird-downflap.png");
        return birdDownFlap;
    }
    public ImageAsset birdUpFlap() {
        if (this.birdUpFlap != null) return this.birdUpFlap;
        birdUpFlap = new BirdUpFlap("bird-upflap.png");
        return birdUpFlap;
    }
}
