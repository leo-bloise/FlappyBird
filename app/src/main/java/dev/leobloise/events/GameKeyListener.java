package dev.leobloise.events;

import dev.leobloise.entities.GameMediator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    private final GameMediator gameMediator;
    public GameKeyListener(GameMediator gameMediator) {
        this.gameMediator = gameMediator;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> gameMediator.notify(GameEvent.JUMP_BIRD);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
}
