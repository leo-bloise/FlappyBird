package dev.leobloise.builders;

import dev.leobloise.components.Bird;

public class BirdBuilder {
    private final AssetsBuilder assetsBuilder;
    private Bird bird;
    public BirdBuilder(AssetsBuilder assetsBuilder) {
        this.assetsBuilder = assetsBuilder;
    }
    public Bird build() {
        if (bird != null) return bird;
        bird = new Bird(
                assetsBuilder.birdMidFlap(),
                assetsBuilder.birdMidFlap(),
                assetsBuilder.birdMidFlap()
        );
        return bird;
    }
}
