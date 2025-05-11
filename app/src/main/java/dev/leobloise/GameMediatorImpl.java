package dev.leobloise;

import dev.leobloise.actions.GameAction;
import dev.leobloise.actions.MoveBackgroundAction;
import dev.leobloise.actions.MoveBirdAction;
import dev.leobloise.components.Background;
import dev.leobloise.components.Bird;
import dev.leobloise.entities.GameMediator;
import dev.leobloise.entities.Moveable;
import dev.leobloise.events.GameEvent;
import dev.leobloise.events.GameKeyListener;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameMediatorImpl implements GameMediator {
    private Bird bird;
    private Moveable background;
    private final LinkedList<GameAction> actions = new LinkedList<>();
    public GameMediatorImpl(
            Canvas gameCanvas,
            Bird bird,
            Moveable background
    ) {
        this.bird = bird;
        this.background = background;
        setUp(gameCanvas);
    }
    private void setUp(Canvas canvas) {
        canvas.addKeyListener(new GameKeyListener(this));
    }
    private void handleJump() {
        actions.add(new MoveBirdAction(bird));
    }
    private void handleMove() {
        actions.add(new MoveBackgroundAction(background, bird));
    }
    @Override
    public void notify(GameEvent event) {
        switch (event) {
            case GameEvent.JUMP_BIRD -> handleJump();
            case GameEvent.MOVE -> handleMove();
        }
    }
    @Override
    public List<GameAction> flushActions() {
        List<GameAction> gameActionsList = List.copyOf(actions);
        actions.clear();
        notify(GameEvent.MOVE);
        return gameActionsList;
    }
}
