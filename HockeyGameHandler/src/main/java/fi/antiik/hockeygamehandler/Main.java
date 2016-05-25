/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler;

import fi.antiik.hockeygamehandler.*;
import fi.antiik.hockeygamehandler.logic.*;

import java.util.*;

/**
 *
 * @author janantik
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Standings standing = new Standings("Testi");
        standing.addPlayer("Janne");
        standing.addPlayer("Kalle");
        standing.printStandings();
        standing.getPlayer("Kalle").addGame(3, 2);
        standing.printStandings();
        standing.getPlayer("Janne").addGame(4, 1);
        standing.printStandings();
        standing.getPlayer("Janne").addGame(2, 2);
        standing.printStandings();

    }
}
