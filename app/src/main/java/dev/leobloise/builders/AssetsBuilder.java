package dev.leobloise.builders;

import dev.leobloise.components.Background;
import dev.leobloise.images.BirdMidFlap;
import dev.leobloise.images.ImageAsset;

public class AssetsBuilder {
    private Background background;
    private ImageAsset birdMidFlap;
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
}
