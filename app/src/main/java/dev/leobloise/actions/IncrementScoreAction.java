// TODO: CHECK HOW TO CHANGE THE SIZE
package dev.leobloise.actions;

import dev.leobloise.components.Bird;
import dev.leobloise.components.PipeGreen;
import dev.leobloise.entities.GameMediator;
import dev.leobloise.events.GameEvent;

import java.util.List;

public class IncrementScoreAction implements GameAction {
    private Bird bird;
    private List<PipeGreen> pipeGreens;
    private GameMediator gameMediator;
    public IncrementScoreAction(Bird bird, List<PipeGreen> pipeGreens, GameMediator gameMediator) {
        this.gameMediator = gameMediator;
        this.bird = bird;
        this.pipeGreens = pipeGreens;
    }
    @Override
    public void execute() {
        for (PipeGreen pipeGreen: pipeGreens) {
            if (pipeGreen.getPassed()) continue;
            if ((pipeGreen.getX() + 52) <  bird.getX()) {
                this.gameMediator.notify(GameEvent.ADD_SCORE);
                pipeGreen.setPassed(true);
                break;
            }
        }
    }
}
