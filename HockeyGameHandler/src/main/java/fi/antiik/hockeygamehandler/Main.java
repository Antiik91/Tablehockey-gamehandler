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
        Player jarkko = new Player("Jarkko");
        standing.addPlayer(janne);
        standing.addPlayer(ville);
        standing.addPlayer(jarkko);
        janne.addGame(1, 3);
        ville.addGame(9, 3);
        janne.addGame(5, 1);
        janne.addGame(4, 0);
        janne.addGame(0, 2);
        janne.addGame(1, 4);
        System.out.println("Jannen pisteet: " + janne.getPoints());
        System.out.println("Villen pisteet: " + ville.getPoints());
        System.out.println("Jarkon pisteet: " + jarkko.getPoints());
        System.out.println("Jannen voittopros: " + janne.getWinPrecentage());
        ArrayList<Player> test = standing.getStandings();
        for (Player player : test) {
            System.out.println(player);
        }
    }
}
