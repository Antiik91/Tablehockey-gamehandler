package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.filehandler.DataStorage;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Referee {

    Player one;
    Player two;
    Standings standings;
    DataStorage storage;

    public Referee(Player one, Player two, Standings standings) {
        if (one == two) {
            throw new IllegalArgumentException("You can't play against yourself!");

        }
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
        countdown(10);
    }

    public void countdown(int timeInSeconds) {
        if (timeInSeconds <= 0) {
            throw new IllegalArgumentException("Time in seconds must be positive!");

        }
        int timeLeft = timeInSeconds;
        while (timeLeft > 0) {
            try {
                System.out.println(timeLeft);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Referee.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeLeft--;
        }

    }

    public void results(int playerOneScores, int playerTwoScores) {
        if (playerOneScores < 0) {
            playerOneScores *= -1;
        }
        if (playerTwoScores < 0) {
            playerTwoScores *= -1;
        }
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
