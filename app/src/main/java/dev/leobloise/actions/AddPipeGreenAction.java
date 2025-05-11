package dev.leobloise.actions;

import dev.leobloise.components.GameCanvas;
import dev.leobloise.components.PipeGreen;
import dev.leobloise.components.PipeGreenFactory;
import java.util.Deque;

public class AddPipeGreenAction implements GameAction {
    private final Deque<PipeGreen> pipes;
    private final GameCanvas gameCanvas;
    private final PipeGreen pipeGreenReference = new PipeGreen(0, 0);
    public AddPipeGreenAction(Deque<PipeGreen> pipeGreens, GameCanvas gameCanvas) {
        this.pipes = pipeGreens;
        this.gameCanvas = gameCanvas;
    }
    private void createPipe() {
        PipeGreen pipeGreen = PipeGreenFactory.getInstance().create();
        pipes.add(pipeGreen);
        gameCanvas.addToCanvas(pipeGreen);
        System.out.println(pipes.size());
    }
    @Override
    public synchronized void execute() {
        PipeGreen last = pipes.peekLast();
        if (last == null) {
            createPipe();
            return;
        }
        int pipeX = last.getX();
        int twoPipesWidth = pipeGreenReference.getWidth() * 2;
        if (pipeX < twoPipesWidth) {
            createPipe();
        }
    }
}
