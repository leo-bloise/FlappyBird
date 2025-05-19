package dev.leobloise.actions;

import dev.leobloise.components.Bird;
import dev.leobloise.entities.GameAudio;

public class MoveBirdAction implements GameAction{
    private Bird bird;
    private final GameAudio gameAudio;
    public MoveBirdAction(Bird bird) {
        this.bird = bird;
        this.gameAudio = new GameAudio("wing.wav");
        gameAudio.read();
    }
    @Override
    public synchronized void execute() {
        bird.move();
        gameAudio.play();
    }
}
