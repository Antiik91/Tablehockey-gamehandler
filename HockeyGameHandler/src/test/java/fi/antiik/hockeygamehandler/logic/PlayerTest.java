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

    // *******************************Testing for setters. No negative parameters are allowed *************************************

    @Test
    public void noNegativeGoalsFor() {
        player.addGame(2, 1);
        player.setGoalsFor(-4);
        assertEquals(2, player.getGoalsFor());
    }

    @Test
    public void noNegativeGames() {
        player.addGame(2, 4);
        player.addGame(2, 1);
        player.setGamesPlayed(-24);
        assertEquals(2, player.getGamesPlayed());
    }

    @Test
    public void noNegativeGoalsAgainst() {
        player.addGame(4, 33);
        player.setGoalsAgainst(-2);
        assertEquals(33, player.getGoalsAgainst());
    }

    @Test
    public void noNegativePoints() {
        player.addGame(2, 1);
        player.addGame(1, 1);
        player.setPoints(-22);
        assertEquals(4, player.getPoints());
    }

    @Test
    public void noNegativeWins() {
        player.addGame(1, 0);
        player.setWins(-1);
        assertEquals(1, player.getWins());
    }

    @Test
    public void noNegativeLosses() {
        player.addGame(2, 4);
        player.setLosses(-22);
        assertEquals(1, player.getLosses());
    }

    @Test
    public void noNegativeTies() {
        player.addGame(1, 1);
        player.addGame(2, 2);
        assertEquals(2, player.getTies());
    }
    // *******************************************************************************************************************************

    @Test
    public void correctPointsAfterWins() {
        for (int i = 0; i < 10; i++) {
            player.addGame(3, 1);
        }
        assertEquals(30, player.getPoints());
    }

    @Test
    public void lossesWontAddPoints() {
        player.addGame(1, 0);
        for (int i = 0; i < 20; i++) {
            player.addGame(0, 1);
        }
        assertEquals(3, player.getPoints());
    }

    @Test
    public void correctPointsAfterTies() {
        for (int i = 0; i < 10; i++) {
            player.addGame(1, 1);
        }
        assertEquals(10, player.getPoints());
    }

    @Test
    public void correctWinPrecentageAfter10Wins() {
        for (int i = 0; i < 10; i++) {
            player.addGame(1, 0);
        }
        assertEquals(100, player.getWinPrecentage());
    }

    public void correctWinPrecentageAfter5Wins5Losses() {
        for (int i = 0; i < 5; i++) {
            player.addGame(1, 0);
        }
        for (int i = 0; i < 5; i++) {
            player.addGame(0, 1);
        }
        assertEquals(50, player.getWinPrecentage());
    }

    @Test
    public void winPrecentage30() {
        for (int i = 0; i < 7; i++) {
            player.addGame(i, i + 1);
        }
        for (int i = 0; i < 3; i++) {
            player.addGame(i + 1, i);
        }
        assertEquals(30, player.getWinPrecentage());
    }

    @Test
    public void winPrecentageZero() {
        for (int i = 0; i < 10; i++) {
            player.addGame(0, i);
        }
        assertEquals(0, player.getWinPrecentage());
    }
}
