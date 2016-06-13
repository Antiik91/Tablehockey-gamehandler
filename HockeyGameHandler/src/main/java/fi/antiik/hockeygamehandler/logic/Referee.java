package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.filehandler.DataStorage;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author janantik
 *
 * @version 0.5
 *
 * @since 0.01
 *
 * Class handles the Countdown of gametime and playing sound effects needed in
 * the game
 */
public class Referee {

    Player one;
    Player two;
    Standings standings;
    DataStorage storage;

    public Referee(Player one, Player two, Standings standings) {
        if (one == two) {
            throw new IllegalArgumentException("You can't play against yourself! " + one.getName() + " " + two.getName());

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

    /**
     * Starts the game by playing countdown5.waw sound and then counting down
     * first 5 seconds to begin the game and then 300 secs gametime
     */
    public void startGame() {
        Speak("src/music/Countdown5.wav");
        countdown(5);
    }

    /**
     * Method counts down time in second using Thread.sleep()
     *
     * @param timeInSeconds starting time in seconds.
     */
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

    /**
     * After the countdown is complete results are to be handled. Method checks
     * the scores of player one and two and gives them to Player addScores()
     * method.
     *
     * @param playerOneScores scores for player one
     * @param playerTwoScores scores for player two
     */
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

    /**
     * Plays soundeffects given in param filename
     *
     * @param filename source where the filename is found
     */
   public void Speak(String filename) {
       SoundPlayer.playSound(filename);
   }
}
