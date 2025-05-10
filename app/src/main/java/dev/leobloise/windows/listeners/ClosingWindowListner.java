package dev.leobloise.windows.listeners;

import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ClosingWindowListner implements WindowListener {
    private final boolean terminate;
    public ClosingWindowListner(boolean terminate) {
        this.terminate = terminate;
    }
    @Override
    public void windowOpened(WindowEvent e) {
    }
    @Override
    public void windowClosing(WindowEvent e) {
        Window window = e.getWindow();
        window.dispose();
        if (terminate) System.exit(0);
    }
    @Override
    public void windowClosed(WindowEvent e) {

    }
    @Override
    public void windowIconified(WindowEvent e) {

    }
    @Override
    public void windowDeiconified(WindowEvent e) {

    }
    @Override
    public void windowActivated(WindowEvent e) {

    }
    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
