package dev.leobloise.builders;

import dev.leobloise.components.Background;
import dev.leobloise.images.BirdDownFlap;
import dev.leobloise.images.BirdMidFlap;
import dev.leobloise.images.BirdUpFlap;
import dev.leobloise.images.ImageAsset;

public class AssetsBuilder {
    private Background background;
    private ImageAsset birdMidFlap;
    private ImageAsset birdDownFlap;
    private ImageAsset birdUpFlap;
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
