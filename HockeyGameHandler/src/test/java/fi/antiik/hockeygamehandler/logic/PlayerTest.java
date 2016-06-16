/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author User
 */
public class PlayerTest {

    Player player;

    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        player = new Player("Kalle");
    }

    @After
    public void tearDown() {
    }

    // *******************************Tests for setters.*************************************
    @Test
    public void noNegativeGoalsFor() {
        player.addScores(2, 1);
        player.setGoalsFor(-4);
        assertEquals(2, player.getGoalsFor());
    }

    @Test
    public void noNegativeGames() {
        player.addScores(2, 4);
        player.addScores(2, 1);
        player.setGamesPlayed(-24);
        assertEquals(2, player.getGamesPlayed());
    }

    @Test
    public void noNegativeGoalsAgainst() {
        player.addScores(4, 33);
        player.setGoalsAgainst(-2);
        assertEquals(33, player.getGoalsAgainst());
    }

    @Test
    public void noNegativePoints() {
        player.addScores(2, 1);
        player.addScores(1, 1);
        player.setPoints(-22);
        assertEquals(4, player.getPoints());
    }

    @Test
    public void noNegativeWins() {
        player.addScores(1, 0);
        player.setWins(-1);
        assertEquals(1, player.getWins());
    }

    @Test
    public void noNegativeLosses() {
        player.addScores(2, 4);
        player.setLosses(-22);
        assertEquals(1, player.getLosses());
    }

    @Test
    public void noNegativeTies() {
        player.addScores(1, 1);
        player.addScores(2, 2);
        assertEquals(2, player.getTies());
    }

    @Test
    public void setZeroGames() {
        this.player.setGamesPlayed(0);
        assertEquals(0, this.player.getGamesPlayed());
    }

    @Test
    public void setPositiveGames() {
        this.player.setGamesPlayed(23);
        assertEquals(23, this.player.getGamesPlayed());
    }

    @Test
    public void setZeroWins() {
        this.player.setWins(0);
        assertEquals(0, this.player.getWins());
    }

    @Test
    public void setPositiveWins() {
        this.player.setWins(3);
        assertEquals(3, this.player.getWins());
    }

    @Test
    public void setZeroLosses() {
        this.player.setLosses(0);
        assertEquals(0, this.player.getLosses());
    }

    @Test
    public void setPositiveLosses() {
        this.player.setLosses(33);
        assertEquals(33, this.player.getLosses());
    }

    @Test
    public void zeroTies() {
        this.player.setTies(0);
        assertEquals(0, this.player.getTies());
    }

    @Test
    public void positiveTies() {
        this.player.setTies(22);
        assertEquals(22, this.player.getTies());
    }

    @Test
    public void zeroPoints() {
        this.player.setPoints(0);
        assertEquals(0, this.player.getPoints());
    }

    @Test
    public void positivePoints() {
        this.player.setPoints(2);
        assertEquals(2, this.player.getPoints());
    }

    @Test
    public void zeroGoalsFor() {
        this.player.setGoalsFor(0);
        assertEquals(0, this.player.getGoalsFor());
    }

    @Test
    public void positiveGoalsFor() {
        this.player.setGoalsFor(2);
        assertEquals(2, this.player.getGoalsFor());
    }

    @Test
    public void zeroGoalsAgainst() {
        this.player.setGoalsAgainst(0);
        assertEquals(0, this.player.getGoalsAgainst());
    }

    @Test
    public void positiveGoalsAgainst() {
        this.player.setGoalsAgainst(23);
        assertEquals(23, this.player.getGoalsAgainst());
    }

    // *******************************************************************************************************************************
    @Test
    public void correctPointsAfterWins() {
        for (int i = 0; i < 10; i++) {
            player.addScores(3, 1);
        }
        assertEquals(30, player.getPoints());
    }

    @Test
    public void lossesWontAddPoints() {
        player.addScores(1, 0);
        for (int i = 0; i < 20; i++) {
            player.addScores(0, 1);
        }
        assertEquals(3, player.getPoints());
    }

    @Test
    public void correctPointsAfterTies() {
        for (int i = 0; i < 10; i++) {
            player.addScores(1, 1);
        }
        assertEquals(10, player.getPoints());
    }

    @Test
    public void correctWinPrecentageAfter10Wins() {
        for (int i = 0; i < 10; i++) {
            player.addScores(1, 0);
        }
        assertEquals(100, player.getWinPrecentage());
    }

    public void correctWinPrecentageAfter5Wins5Losses() {
        for (int i = 0; i < 5; i++) {
            player.addScores(1, 0);
        }
        for (int i = 0; i < 5; i++) {
            player.addScores(0, 1);
        }
        assertEquals(50, player.getWinPrecentage());
    }

    @Test
    public void winPrecentage30() {
        for (int i = 0; i < 7; i++) {
            player.addScores(i, i + 1);
        }
        for (int i = 0; i < 3; i++) {
            player.addScores(i + 1, i);
        }
        assertEquals(30, player.getWinPrecentage());
    }

    @Test
    public void winPrecentageZero() {
        for (int i = 0; i < 10; i++) {
            player.addScores(0, i);
        }
        assertEquals(0, player.getWinPrecentage());
    }

    @Test
    public void equalityCheck() {
        Player p1 = new Player("P1");
        Player p2 = new Player("P1");
        boolean isSame = false;
        if (p1.equals(p2)) {
            isSame = true;
        }
        assertEquals(true, isSame);
    }

    @Test
    public void equalToNull() {
        assertFalse(this.player.equals(null));
    }

    @Test
    public void compareCheckP1MorePoints() {
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");

        p1.addScores(4, 1);
        p2.addScores(1, 4);
        int result = p1.compareTo(p2);
        assertEquals(-1, result);
    }

    @Test
    public void compareCheckP1EqualPointsEqualWinsMoreGoals() {
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        p1.addScores(4, 1);
        p2.addScores(2, 0);
        int result = p1.compareTo(p2);
        assertEquals(-1, result);
    }

    @Test
    public void compareCheckP1WqualPointsMoreWins() {
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        p1.addScores(10, 0);
        for (int i = 0; i < 3; i++) {
            p2.addScores(1, 1);
        }
        int result = p1.compareTo(p2);
        assertEquals(-1, result);
    }

    @Test
    public void compareCheckEquals() {
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        p1.addScores(3, 3);
        p2.addScores(3, 3);
        int result = p1.compareTo(p2);
        assertEquals(0, result);
    }
}
