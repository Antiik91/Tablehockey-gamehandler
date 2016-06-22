/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.gui.GUI;
import java.io.FileNotFoundException;
import javax.sound.sampled.LineUnavailableException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author User
 */
public class RefereeTest {

    Player player1;
    Player player2;
    Referee referee;
    Standings standing;
    private GUI gui;
    private Logic logic;

    public RefereeTest() {
    }

    @Before
    public void setUp() {
        standing = new Standings("TestStanding");
        standing.addPlayer("One");
        standing.addPlayer("Two");
        player1 = standing.getPlayer("One");
        player2 = standing.getPlayer("Two");

        referee = new Referee(player1, player2, standing, gui, logic);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void playerOneScoresNegative() {
        referee.results(-2, 2);
        assertEquals(2, player1.getGoalsFor());
    }

    @Test
    public void playerTwoScoresNegative() {
        int negativeGoals = -2;
        referee.results(2, negativeGoals);
        assertEquals(2, player2.getGoalsFor());
    }

    public void hundredGames() {
        for (int i = 0; i < 100; i++) {
            referee.results(3, 2);
        }
    }
    
    @Test
    public void timerIsRunning(){
        this.referee.startGame();
        assertTrue(this.referee.getTimer().isRunning());
    }

    @Test
    public void multipleGamesScoresCorrectPlayer1() {
        hundredGames();
        assertEquals(300, player1.getGoalsFor());
    }

    @Test
    public void multipleGamesScoresCorrectPlayer2() {
        hundredGames();
        assertEquals(200, player2.getGoalsFor());
    }

    @Test
    public void zeroScoresPlayer1() {
        int zeroGoals = 0;
        this.referee.results(zeroGoals, 2);
        assertEquals(zeroGoals, this.referee.getPlayerOne().getGoalsFor());
    }

    @Test
    public void zeroScoresPlayer2() {
        int zeroGoals = 0;
        this.referee.results(2, zeroGoals);
        assertEquals(zeroGoals, this.referee.getPlayerTwo().getGoalsFor());
    }

    @Test
    public void negativesP1() {
        this.referee.results(-2, 22);
        assertTrue(this.referee.getPlayerOne().getGoalsFor() == -2 * -1);
    }

    @Test
    public void timeInSecondsCantBeNegative() {
        Throwable expectedException = null;
        try {
            referee.countdown(-44);
        } catch (Throwable exception) {
            expectedException = exception;
        }
        assertTrue(expectedException instanceof IllegalArgumentException);
    }

    @Test
    public void timeInSecondsCantBeZero() {
        Throwable expectedException = null;
        try {
            this.referee.countdown(0);
        } catch (Throwable e) {
            expectedException = e;
        }
        assertTrue(expectedException instanceof IllegalArgumentException);
    }

    @Test
    public void playersCantPlayAgainstItself() {
        Throwable exception = null;
        try {
            Referee testRef = new Referee(player1, player1, standing, gui, logic);
        } catch (Throwable ex) {
            exception = ex;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }

    @Test
    public void correctPlayerOne() {
        String equals = "One 0 0 0 0 0 0 0 0";
        assertEquals(equals, referee.getPlayerOne().toString());
    }

    @Test
    public void correctPlayerTwo() {
        String equals = "Two 0 0 0 0 0 0 0 0";
        assertEquals(equals, referee.getPlayerTwo().toString());
    }

}
