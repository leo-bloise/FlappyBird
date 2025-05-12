package dev.leobloise.actions;

import dev.leobloise.components.Bird;
import dev.leobloise.components.CollidablePipeArea;
import dev.leobloise.components.PipeGreen;

import java.util.List;

public class CheckCollisionAction implements GameAction {
    private final Bird bird;
    private final List<PipeGreen> pipeGreens;
    public CheckCollisionAction(
            Bird bird,
            List<PipeGreen> pipeGreens
    ) {
        this.bird = bird;
        this.pipeGreens = pipeGreens;
    }
    private boolean collideWithUpPipe() {
        for (PipeGreen pipeGreen : pipeGreens) {
            CollidablePipeArea collidablePipeArea = pipeGreen.getCollidablePipeArea();
            if (
                    (bird.getX() + bird.getWidth()) >= collidablePipeArea.xu() &&
                            bird.getX() <= (collidablePipeArea.xu() + 50) &&
                            (bird.getY() + bird.getHeight()) >= (collidablePipeArea.yu()) &&
                            bird.getY() <= collidablePipeArea.yu() + collidablePipeArea.hu()
            ) return true;
        }
        return false;
    }
    private boolean collideWithBottomPipe() {
        // #TO-DO REPLACE 50 for the size of the spritee
        for (PipeGreen pipeGreen : pipeGreens) {
            CollidablePipeArea collidablePipeArea = pipeGreen.getCollidablePipeArea();
            if (
                    (bird.getX() + bird.getWidth()) >= collidablePipeArea.xb() &&
                            bird.getX() <= (collidablePipeArea.xb() + 50) &&
                            (bird.getY() + bird.getHeight()) >= (collidablePipeArea.yb()) &&
                            bird.getY() <= collidablePipeArea.yb() + collidablePipeArea.hb()
            ) return true;
        }
        return false;
    }
    @Override
    public void execute() {
        if (this.collideWithBottomPipe() || this.collideWithUpPipe()) {
            System.out.println("Collision detected");
        }
    }
}
