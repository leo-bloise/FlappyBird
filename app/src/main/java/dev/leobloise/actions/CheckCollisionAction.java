// TODO: Replace 50 for the real size of the pipeGreen
package dev.leobloise.actions;

import dev.leobloise.components.Bird;
import dev.leobloise.components.CollidablePipeArea;
import dev.leobloise.components.PipeGreen;
import dev.leobloise.entities.GameMediator;
import dev.leobloise.events.GameEvent;

import java.util.List;

public class CheckCollisionAction implements GameAction {
    private final Bird bird;
    private final List<PipeGreen> pipeGreens;
    private final GameMediator gameMediator;
    public CheckCollisionAction(
            Bird bird,
            List<PipeGreen> pipeGreens,
            GameMediator gameMediator
    ) {
        this.bird = bird;
        this.pipeGreens = pipeGreens;
        this.gameMediator = gameMediator;
    }
    private PipeGreen closestPipe() {
        int l = 0;
        int r = pipeGreens.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            PipeGreen pipeGreen = pipeGreens.get(m);
            int distanceFromBegin = pipeGreen.getX() - (bird.getX() + bird.getWidth());
            int distanceFromEnd = (pipeGreen.getX() + 52) - bird.getX();
            if (distanceFromBegin < 0 && distanceFromEnd < 0) {
                l = m + 1;
                continue;
            }
            if (distanceFromBegin <= 20) {
                return pipeGreen;
            }
            r = m -1;
        }
        return null;
    }
    private boolean collideWithUpPipe() {
        PipeGreen pipeGreen = closestPipe();
        if (pipeGreen == null) return false;
        CollidablePipeArea collidablePipeArea = pipeGreen.getCollidablePipeArea();
        return (bird.getX() + bird.getWidth()) >= collidablePipeArea.xu() &&
                bird.getX() <= (collidablePipeArea.xu() + 50) &&
                (bird.getY() + bird.getHeight()) >= (collidablePipeArea.yu()) &&
                bird.getY() <= collidablePipeArea.yu() + collidablePipeArea.hu();
    }
    private boolean collideWithBottomPipe() {
        PipeGreen pipeGreen = closestPipe();
        if (pipeGreen == null) return false;
        CollidablePipeArea collidablePipeArea = pipeGreen.getCollidablePipeArea();
        return (bird.getX() + bird.getWidth()) >= collidablePipeArea.xb() &&
                bird.getX() <= (collidablePipeArea.xb() + 50) &&
                (bird.getY() + bird.getHeight()) >= (collidablePipeArea.yb()) &&
                bird.getY() <= collidablePipeArea.yb() + collidablePipeArea.hb();
    }
    @Override
    public void execute() {
        if (pipeGreens.isEmpty()) return;
        if (this.collideWithBottomPipe() || this.collideWithUpPipe()) {
            gameMediator.notify(GameEvent.GAME_OVER);
        }
    }
}
