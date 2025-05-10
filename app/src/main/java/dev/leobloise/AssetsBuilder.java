package dev.leobloise;

import dev.leobloise.images.Background;
import dev.leobloise.images.BirdMidFlap;
import dev.leobloise.images.ImageAsset;

public class AssetsBuilder {
    private ImageAsset background;
    private ImageAsset birdMidFlap;
    public ImageAsset buildBackground() {
        if (background != null) return background;
        background = new Background("background.png");
        return background;
    }
    public ImageAsset birdMidFlap() {
        if (birdMidFlap != null) return birdMidFlap;
        birdMidFlap = new BirdMidFlap("bird-midflap.png");
        return birdMidFlap;
    }
}
