/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author User
 */
public class StandingsTest {

    Standings standings;

    public StandingsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void noPlayersSameNameAllowed() {
        standings = new Standings("TestStandings");
        standings.addPlayer("Janne");
        standings.addPlayer("janne");
        standings.addPlayer("JANNE");
        standings.addPlayer("JANNe");
        standings.addPlayer("JANnE");
        standings.addPlayer("JAnNE");
        standings.addPlayer("JaNNE");
        standings.addPlayer("jANNE");
        assertEquals(1, standings.getSize());
    }

    @Test
    public void playerIsFound() {
        standings = new Standings("TestStandings");
        standings.addPlayer("Janne");
        standings.addPlayer("Ville");
        Player test = new Player("jannE");
        assertEquals(true, standings.standingsContainsPlayer(test.getName()));
    }

    @Test
    public void correctOrdering() {
        Standings compare = new Standings("compare");
        compare.addPlayer("Janne");
        compare.addPlayer("Jarkko");
        compare.addPlayer("Ville");
        standings = new Standings("Teststandings");
        standings.addPlayer("Janne");
        standings.addPlayer("Jarkko");
        standings.addPlayer("Ville");
        standings.getPlayer("Janne").addScores(3, 0);
        standings.getPlayer("Ville").addScores(0, 3);
        standings.getPlayer("Jarkko").addScores(1, 1);
        System.out.println("Järjestys kompare");
        assertEquals(compare.getPlayers(), standings.getPlayers());
    }
}
