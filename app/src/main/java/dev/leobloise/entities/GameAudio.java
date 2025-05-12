package dev.leobloise.entities;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class GameAudio {
    private final String filename;
    private Line.Info info;
    private AudioInputStream audioInputStream;
    private Clip clip;
    public GameAudio(String filename) {
        this.filename = filename;
    }
    private void loadInfo() {
        info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
    }
    private void loadAudioStream() throws UnsupportedAudioFileException, IOException {
        InputStream data = getClass().getClassLoader().getResourceAsStream(filename);
        if (data == null) throw new RuntimeException("No audio found");
        audioInputStream = AudioSystem.getAudioInputStream(data);
    }
    private void createClip() throws LineUnavailableException, IOException {
        clip = (Clip) AudioSystem.getLine(info);
        clip.open(audioInputStream);
    }
    public void play() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }
    public void read() {
        try {
            loadAudioStream();
            loadInfo();
            createClip();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
