/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.gui.GUI;

/**
 * Class runs when a new game is started. It handles time remaining and informs
 * when referee gives voice signals.
 *
 * @author janantik
 *
 */
public class Logic implements Updatable {

    private Referee referee;
    private int timeInSeconds;

    /**
     * Creates a new Referee with given paramaters.
     *
     * @param player1 Player 1 searched from standings
     * @param player2 Player 2 searched from standings
     * @param standings Standings to get players from.
     * @param gui GUI to send referee.
     */
    public Logic(String player1, String player2, Standings standings, GUI gui) {
        if (player1 == null || player1.trim().length() == 0) {
            player1 = "Player " + standings.getSize() + 1;
        }
        if (player2 == null || player2.trim().length() == 0) {
            player2 = "Player " + standings.getSize() + 2;
        }
        this.referee = new Referee(standings.getPlayer(player1), standings.getPlayer(player2), standings, gui, this);

    }

    /**
     * Returns Referee when called.
     *
     * @return Referee currently used
     */
    public Referee getReferee() {
        return this.referee;
    }

    /**
     * Sets new referee if it's not null.
     *
     * @param newReferee Referee to be set.
     */
    public void setReferee(Referee newReferee) {
        if (newReferee != null) {
            this.referee = newReferee;
        }
    }

    /**
     * If timeInSeconds is positive method sets timeInSeconds to timeInseconds.
     * Uses Referee's startGame() method to start the game.
     *
     * @param timeInSeconds time in second to be set
     */
    public void startGame(int timeInSeconds) {
        if (this.referee.getTimer().isRunning() == false) {
            if (timeInSeconds > 0) {
                this.timeInSeconds = timeInSeconds;
                this.referee.startGame();
            }
        }
    }

    /**
     * Sets new timeInSeconds if positive.
     *
     * @param timeInSeconds time in seconds to be set
     */
    public void setTimeInSeconds(int timeInSeconds) {
        if (timeInSeconds > 0) {
            this.timeInSeconds = timeInSeconds;
        }
    }

    /**
     * returns time in seconds.
     *
     * @return timeInSeconds, integer
     */
    public int getTimeinSeconds() {
        return this.timeInSeconds;
    }

    /**
     * Method check the scores are positive or zero and calls Referee's
     * Results(Player1Scores, Player2Scores) to set results for the players
     * statistics.
     *
     * @param player1Scores Scores for Player 1
     * @param player2Scores Scores for Player 2
     */
    public void setScores(int player1Scores, int player2Scores) {
        if (player1Scores >= 0 && player2Scores >= 0) {
            this.referee.results(player1Scores, player2Scores);
        }
    }

    /**
     * returns location of the music files.
     * 
     * @return location of music files
     */
    public String getMusicLocation() {
        String userDir = System.getProperties().getProperty("user.dir");

        String musicFileLocation = userDir + "/music/";
        return musicFileLocation;
    }

    @Override
    public void update() {
        String music = getMusicLocation();
        if (this.timeInSeconds == 1) {
            this.referee.speak(music + "endGame.wav");
        }

        if (this.timeInSeconds == 0) {
            this.referee.stopTimer();
        }
        if (this.timeInSeconds == 60) {
            this.referee.speak(music + "Toy_Train_Whistle.wav");
        }
        this.timeInSeconds--;
    }
}
