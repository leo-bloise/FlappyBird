package dev.leobloise.actions;

import dev.leobloise.components.Bird;

public class MoveBirdAction implements GameAction{
    private Bird bird;
    public MoveBirdAction(Bird bird) {
        this.bird = bird;
    }
    @Override
    public synchronized void execute() {
        bird.move();
    }
}
