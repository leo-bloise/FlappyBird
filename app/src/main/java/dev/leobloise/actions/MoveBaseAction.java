package dev.leobloise.actions;

import dev.leobloise.components.Bird;
import dev.leobloise.entities.Moveable;

public class MoveBaseAction implements GameAction {
    private final Moveable base;
    private final Bird bird;
    public MoveBaseAction(Moveable base, Bird bird) {
        this.base = base;
        this.bird = bird;
    }
    @Override
    public synchronized void execute() {
        base.move();
        bird.applyGravity();
    }
}
