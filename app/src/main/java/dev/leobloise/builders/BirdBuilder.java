package dev.leobloise.builders;

import dev.leobloise.components.Bird;
import dev.leobloise.images.BirdMidFlap;
import dev.leobloise.images.ImageAsset;

public class BirdBuilder {
    private final AssetsBuilder assetsBuilder;
    private Bird bird;
    public BirdBuilder(AssetsBuilder assetsBuilder) {
        this.assetsBuilder = assetsBuilder;
    }
    public Bird build(int x, int y) {
        if (bird != null) return bird;
        ImageAsset birdMidFlap = assetsBuilder.birdMidFlap();
        x -= (birdMidFlap.getWidth() / 2);
        y -= (birdMidFlap.getHeight() / 2);
        bird = new Bird(
                assetsBuilder.birdMidFlap(),
                assetsBuilder.birdMidFlap(),
                assetsBuilder.birdMidFlap(),
                x,
                y
        );
        return bird;
    }
}
