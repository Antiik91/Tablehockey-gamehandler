/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.gui.GUI;
import fi.antiik.hockeygamehandler.gui.TimerListener;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author janantik
 */
public class Logic implements Updatable {

    private Referee referee;
    private GUI gui;
    private int timeInSeconds;

    public Logic(Referee referee) {
        this.referee = referee;
    }

    public Logic(String player1, String player2, Standings standings, GUI gui) {
        this.gui = gui;
        this.referee = new Referee(standings.getPlayer(player1), standings.getPlayer(player2), standings, this.gui, this);

    }

    public Referee getReferee() {
        return this.referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public void startGame(int timeInSeconds) {
        if (timeInSeconds > 0) {
            this.timeInSeconds = timeInSeconds;
            this.referee.startGame();
        }
    }

    public int getTimeinSeconds() {
        return this.timeInSeconds;
    }

    public void addScore(Player player) {

    }

    public void setScores(int player1Scores, int player2Scores) {
        if (player1Scores >= 0 && player2Scores >= 0) {
            this.referee.results(player1Scores, player2Scores);
        }
    }

    @Override
    public void update() {

        if (this.timeInSeconds == 0) {
            this.referee.speak("src/music/endGame.wav");
            this.gui.setResults(this.referee.getPlayerOne().getName(), this.referee.getPlayerTwo().getName());
            this.referee.stopTimer();
        }
        if (this.timeInSeconds == 60) {
            this.referee.speak("src/music/Toy_Train_Whistle.wav");
        }
        this.timeInSeconds--;
    }
}
