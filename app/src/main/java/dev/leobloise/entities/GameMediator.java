package dev.leobloise.entities;

import dev.leobloise.actions.GameAction;
import dev.leobloise.events.GameEvent;

import java.util.List;

public interface GameMediator {
    void notify(GameEvent event);
    List<GameAction> flushActions();
    boolean isGameOver();
}
