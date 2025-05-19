package dev.leobloise.actions;

import dev.leobloise.components.Base;
import dev.leobloise.components.Bird;
import dev.leobloise.entities.GameMediator;
import dev.leobloise.events.GameEvent;

public class MoveBaseAction implements GameAction {
    private final Base base;
    private final Bird bird;
    private final GameMediator gameMediator;
    public MoveBaseAction(Base base, Bird bird, GameMediator gameMediator) {
        this.base = base;
        this.bird = bird;
        this.gameMediator = gameMediator;
    }
    @Override
    public synchronized void execute() {
        base.move();
        bird.applyGravity();
        int birdY = bird.getY();
        int baseY = base.getY();
        if(birdY >= baseY) {
            gameMediator.notify(GameEvent.GAME_OVER);
        }
    }
}
