package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.gui.SoundPlayer;
import fi.antiik.hockeygamehandler.gui.GUI;
import fi.antiik.hockeygamehandler.gui.TimerListener;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 * Class handles the Countdown before the game starts and playing sound effects
 * needed in the game.
 *
 * @author janantik
 *
 * @version 0.5
 *
 * @since 0.01
 *
 *
 */
public class Referee {

    private Player one;
    private Player two;
    private Standings standings;
    private GUI gui;
    private Logic logic;
    private Timer timer;

    /**
     * Checks that players can't play against itself.
     *
     * @param one Player one
     * @param two Player two
     * @param standings Standings Where Players are competing
     * @param gui GUI to be sent in TimerListener
     * @param logic to be sent in TimerListener
     */
    public Referee(Player one, Player two, Standings standings, GUI gui, Logic logic) {
        if (one.equals(two)) {
            throw new IllegalArgumentException("You can't play against yourself! " + one.getName() + " " + two.getName());

        }
        this.one = one;
        this.two = two;
        this.standings = standings;
        this.gui = gui;
        this.logic = logic;
        ArrayList<Updatable> updatables = new ArrayList<>();
        updatables.add(this.logic);
        updatables.add(this.gui);

        this.timer = new Timer(1000, new TimerListener(updatables));
        timer.setInitialDelay(1000);

    }

    /**
     * Returns player One.
     *
     * @return Player one
     */
    public Player getPlayerOne() {
        return one;
    }

    /**
     * Returns player Two.
     *
     * @return Player Two
     */
    public Player getPlayerTwo() {
        return two;
    }

    /**
     * Starts the game by playing countdown5.waw sound and counting down first 5
     * seconds to begin the game. After that then Starts timer which starts the
     * game.
     */
    public void startGame() {
        String userDir = System.getProperties().getProperty("user.dir");

        String musicFileLocation = userDir + "/music/";
        speak(musicFileLocation + "Countdown5.wav");

        countdown(5);

        timer.start();
    }

    /**
     * Method counts down time in second using Thread.sleep().
     *
     * Used to sync Countdown5.wav with real time before game begins
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
//                System.out.println(timeLeft);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Referee.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeLeft--;
        }

    }

    /**
     * After the game is complete results are to be handled.
     *
     * Method checks the scores of player one and two and gives them to Player
     * addScores() method.
     *
     * @param playerOneScores scores for player one
     * @param playerTwoScores scores for player two
     */
    public void results(int playerOneScores, int playerTwoScores) {

        standings.getPlayer(one.getName()).addScores(Math.abs(playerOneScores), Math.abs(playerTwoScores));
        standings.getPlayer(two.getName()).addScores(Math.abs(playerTwoScores), Math.abs(playerOneScores));
    }

    /**
     * Plays soundeffects given in param filename.
     *
     * @param filename source where the filename is found
     */
    public void speak(String filename) {
        SoundPlayer.playSound(filename);
    }

    /**
     * Stops the Timer when called.
     */
    public void stopTimer() {
        this.timer.stop();
    }

    public Timer getTimer() {
        return timer;
    }
}
