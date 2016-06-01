package fi.antiik.hockeygamehandler.logic;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import sun.audio.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game {

    Player one;
    Player two;
    Standings standings;
    Scanner scanner;
    DataStorage storage;

    public Game(Player one, Player two, Standings standings, Scanner scanner) {
        this.one = one;
        this.two = two;
        this.standings = standings;
        this.scanner = scanner;
    }

    public void startGame() {
        System.out.println("Press any key to start: ");
        scanner.nextLine();
        System.out.println("GET READY!");

        playSound("src/music/Countdown5.wav");
        countdown(5);
        System.out.println("GO!");
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
        if (timeInSeconds > 10) {
            results();
        }
    }

    private void results() {
        System.out.println("Scores for " + one.getName());
        int scoresFor1 = scanner.nextInt();
        System.out.println("Scores for " + two.getName());
        int scoresFor2 = scanner.nextInt();
        standings.getPlayer(one.getName()).addScores(scoresFor1, scoresFor2);
        standings.getPlayer(two.getName()).addScores(scoresFor2, scoresFor1);
        System.out.println("Standings now: ");
        standings.printStandings();

    }

    // doesn't work yet.
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
