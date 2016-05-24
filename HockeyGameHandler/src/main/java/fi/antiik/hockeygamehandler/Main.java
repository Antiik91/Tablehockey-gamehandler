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
        Player janne = new Player("Janne");
        Player ville = new Player("ville");
        Player janne1 = new Player(("Janne"));
        Player janne2 = new Player("janne");
        standing.addPlayer(janne);
        standing.addPlayer(ville);
        standing.addPlayer(janne1);
        standing.addPlayer(janne2);
        ArrayList<Player> test = standing.getStandings();
        for (Player player : test) {
            System.out.println(player);
        }
    }
}
