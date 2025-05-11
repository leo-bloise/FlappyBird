package dev.leobloise.actions;

import dev.leobloise.components.Bird;
import dev.leobloise.entities.Moveable;

public class MoveBackgroundAction implements GameAction {
    private final Moveable background;
    private final Bird bird;
    public MoveBackgroundAction(Moveable background, Bird bird) {
        this.background = background;
        this.bird = bird;
    }
    @Override
    public synchronized void execute() {
        background.move();
        bird.applyGravity();
    }
}
