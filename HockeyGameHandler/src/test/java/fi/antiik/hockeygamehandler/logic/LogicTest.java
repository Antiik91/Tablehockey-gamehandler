/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.gui.GUI;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class LogicTest {

    private Logic logic;
    private Standings standings;
    private GUI gui;
    private Referee referee;

    public LogicTest() {
        standings = new Standings("TestStanding");
        this.logic = new Logic("Test1", "test2", standings, gui);
        this.standings.addPlayer("Test1");
        this.standings.addPlayer("Test2");
        this.referee = this.logic.getReferee();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void setTimeInSecondsWorks() {
        this.logic.setTimeInSeconds(100000);
        assertEquals(100000, this.logic.getTimeinSeconds());
    }

    @Test
    public void setNegativeTime() {
        this.logic.setTimeInSeconds(-100);
        assertEquals(0, this.logic.getTimeinSeconds());
    }

    @Test
    public void setZeroTime() {
        this.logic.setTimeInSeconds(30);
        this.logic.setTimeInSeconds(0);
        assertEquals(30, this.logic.getTimeinSeconds());
    }
    
    @Test
    public void setRefereeDoesNotAcceptNull() {
        this.logic.setReferee(null);
        assertEquals(this.referee, this.logic.getReferee());
    }
    @Test
    public void setRefereeChangesReferee(){
        Player new1 = new Player("NewP1");
        Player new2 = new Player("NewP2");
        Referee compareReferee = new Referee(new1, new2, standings, gui, logic);
        this.logic.setReferee(compareReferee);
        assertEquals(compareReferee, this.logic.getReferee());
    }

    @Test
    public void setPlayer1ScorePositive() {

        Player comparePlayer = this.referee.getPlayerOne();
        this.logic.setScores(23, 0);
        assertEquals(23, comparePlayer.getGoalsFor());
    }

    @Test
    public void setPlayer1ScoreZero() {

        this.logic.setScores(0, 2);
        assertEquals(0, this.referee.getPlayerOne().getGoalsFor());
    }
    
    @Test
    public void startGameWithZeroTime() {
        this.logic.setTimeInSeconds(20);
        this.logic.startGame(0);
        assertEquals(20, this.logic.getTimeinSeconds()); 
    }
    
    @Test
    public void startgameWithNegativeTime() {
        this.logic.setTimeInSeconds(20);
        this.logic.startGame(-21);
        assertEquals(20, this.logic.getTimeinSeconds());
    }

    @Test
    public void setPlayerScoreNegativeResultsZero() {
        this.logic.setScores(-21, 0);
        assertEquals(0, this.referee.getPlayerOne().getGoalsFor());
    }

    @Test
    public void setPlayer2ScorePositive() {
        this.logic.setScores(0, 5);
        assertEquals(5, this.referee.getPlayerTwo().getGoalsFor());
    }
    
    @Test
    public void setPlayer2ScoreZero() {
        this.logic.setScores(0, 0);
        assertEquals(0, this.referee.getPlayerTwo().getGoalsFor());
    }
    
    @Test
    public void setPlayer2SocreNegativeResultsZero() {
        this.logic.setScores(0, -223);
        assertEquals(0, this.referee.getPlayerTwo().getGoalsFor());
    }
    
    @Test
    public void updateReducesTime() {
        this.logic.setTimeInSeconds(20);
        for (int i = 0; i < 10; i++) {
            this.logic.update();
        }
        assertEquals(10, this.logic.getTimeinSeconds());
    }
}
