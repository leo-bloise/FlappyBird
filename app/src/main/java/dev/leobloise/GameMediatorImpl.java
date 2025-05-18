package dev.leobloise;

import dev.leobloise.actions.*;
import dev.leobloise.components.*;
import dev.leobloise.entities.GameMediator;
import dev.leobloise.entities.Moveable;
import dev.leobloise.events.GameEvent;
import dev.leobloise.events.GameKeyListener;
import java.util.*;
import java.util.List;

public class GameMediatorImpl implements GameMediator {
    private final Bird bird;
    private final LinkedList<GameAction> actions = new LinkedList<>();
    private final Deque<PipeGreen> pipes = new ArrayDeque<>();
    private final GameCanvas gameCanvas;
    private boolean gameOver = false;
    private Score score;
    private final Moveable base;
    public GameMediatorImpl(
            GameCanvas gameCanvas,
            Bird bird,
            Score score,
            Base base
    ) {
        this.bird = bird;
        this.gameCanvas = gameCanvas;
        this.score = score;
        this.base = base;
        setUp();
    }
    public boolean isGameOver() {
        return gameOver;
    }
    private void setUp() {
        gameCanvas.addKeyListener(new GameKeyListener(this));
    }
    private void handleJump() {
        actions.add(new MoveBirdAction(bird));
    }
    private void handleMove() {
        actions.add(new MoveBaseAction(base, bird));
        actions.add(new AddPipeGreenAction(pipes, gameCanvas));
        actions.add(new MovePipesAction(pipes.stream().toList()));
        actions.add(new CheckCollisionAction(bird, pipes.stream().toList(), this));
        actions.add(new IncrementScoreAction(bird, pipes.stream().toList(), this));
    }
    private void incrementScore() {
        score.increment();
    }
    private void setGameOver() {
        actions.clear();
        gameOver = true;
    }
    @Override
    public synchronized void notify(GameEvent event) {
        switch (event) {
            case GameEvent.JUMP_BIRD -> handleJump();
            case GameEvent.MOVE -> handleMove();
            case GameEvent.ADD_SCORE -> incrementScore();
            case GameEvent.GAME_OVER -> setGameOver();
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
