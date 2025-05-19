package dev.leobloise.builders;

import dev.leobloise.components.Bird;
import dev.leobloise.images.ImageAsset;

public class BirdBuilder {
    private final AssetsBuilder assetsBuilder;
    private Bird bird;
    public BirdBuilder(AssetsBuilder assetsBuilder) {
        this.assetsBuilder = assetsBuilder;
    }
    public Bird build(int x, int y) {
        if (bird != null) return bird;
        ImageAsset birdSprite = assetsBuilder.buildBirdSprite();
        x -= (birdSprite.getWidth() / 2);
        y -= (birdSprite.getHeight() / 2);
        bird = new Bird(
                birdSprite,
                x,
                y
        );
        return bird;
    }
}
