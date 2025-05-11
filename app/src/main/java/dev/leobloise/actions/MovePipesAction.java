package dev.leobloise.actions;

import dev.leobloise.components.PipeGreen;

import java.util.List;

public class MovePipesAction implements GameAction {
    private List<PipeGreen> pipeGreens;
    public MovePipesAction(List<PipeGreen> pipeGreens) {
        this.pipeGreens = pipeGreens;
    }
    @Override
    public synchronized void execute() {
        pipeGreens.forEach(PipeGreen::move);
    }
}
