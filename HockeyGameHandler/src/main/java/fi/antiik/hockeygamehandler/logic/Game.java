package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.fileHandling.DataStorage;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game {

    Player one;
    Player two;
    Standings standings;
    DataStorage storage;

    public Game(Player one, Player two, Standings standings) {
        this.one = one;
        this.two = two;
        this.standings = standings;
    }   

    public Player getPlayerOne() {
        return one;
    }

    public Player getPlayerTwo() {
        return two;
    }
    
    
    public void startGame() {
        playSound("src/music/Countdown5.wav");
        countdown(5);
        countdown(300);
    }

    public void countdown(int timeInSeconds) {
        int timeLeft = timeInSeconds;
        while (timeLeft > 0) {
            try {
                System.out.println(timeLeft);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeLeft--;
        }

    }

    public void results(int playerOneScores, int playerTwoScores) {
        standings.getPlayer(one.getName()).addScores(playerOneScores, playerTwoScores);
        standings.getPlayer(two.getName()).addScores(playerTwoScores, playerOneScores);
    }

    
    public static void playSound(String filename) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}
