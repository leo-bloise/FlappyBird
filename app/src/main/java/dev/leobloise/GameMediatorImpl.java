package dev.leobloise;

import dev.leobloise.actions.*;
import dev.leobloise.components.*;
import dev.leobloise.entities.GameMediator;
import dev.leobloise.entities.Moveable;
import dev.leobloise.events.GameEvent;
import dev.leobloise.events.GameKeyListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class GameMediatorImpl implements GameMediator {
    private final Bird bird;
    private final Moveable background;
    private final LinkedList<GameAction> actions = new LinkedList<>();
    private final Deque<PipeGreen> pipes = new ArrayDeque<>();
    private final GameCanvas gameCanvas;
    public GameMediatorImpl(
            GameCanvas gameCanvas,
            Bird bird,
            Moveable background
    ) {
        this.bird = bird;
        this.background = background;
        this.gameCanvas = gameCanvas;
        setUp();
    }
    private void setUp() {
        gameCanvas.addKeyListener(new GameKeyListener(this));
    }
    private void handleJump() {
        actions.add(new MoveBirdAction(bird));
    }
    private void handleMove() {
        actions.add(new MoveBackgroundAction(background, bird));
        actions.add(new AddPipeGreenAction(pipes, gameCanvas));
        actions.add(new MovePipesAction(pipes.stream().toList()));
        actions.add(new CheckCollisionAction(bird, pipes.stream().toList()));
    }
    @Override
    public synchronized void notify(GameEvent event) {
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
