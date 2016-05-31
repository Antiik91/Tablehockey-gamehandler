/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler;

import fi.antiik.hockeygamehandler.*;
import fi.antiik.hockeygamehandler.logic.*;
import fi.antiik.hockeygamehandler.testUI.TestUI;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.*;

/**
 *
 * @author janantik
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        DataStorage data = new DataStorage();
//        Standings standing = new Standings("Testi");
//        standing.addPlayer("Janne");
//        standing.addPlayer("Kalle");
//        standing.addPlayer("Ville");
//        standing.printStandings();
//        standing.getPlayer("Kalle").addScores(3, 2);
//        standing.printStandings();
//        standing.getPlayer("Janne").addScores(4, 1);
//        //standing.printStandings();
//        standing.getPlayer("Janne").addScores(2, 2);
//
//        data.saveData(standing);

        // Testing Deserialization
//        Standings test = null;
//        try {
//            FileInputStream standingIn = new FileInputStream("./src/tmp/" + standing.getName() + ".ser");
//            ObjectInputStream in = new ObjectInputStream(standingIn);
//            test = (Standings) in.readObject();
//            in.close();
//            standingIn.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//        } catch (ClassNotFoundException e) {
//            System.out.println("Standings class not found");
//            e.printStackTrace();
//            return;
//        }
//
//        System.out.println("Deserialized Standings..");
//        System.out.println("Name: " + test.getName());
//        System.out.println("Standings: ");
//        test.printStandings();
//        test.getPlayer("Ville").addScores(2, 4);
//        data.saveData(test);
//
//        System.out.println("Testing if changes work ");
//
//        Standings anotherTest = null;
//
//        try {
//            FileInputStream standingIn = new FileInputStream("./src/tmp/" + standing.getName() + ".ser");
//            ObjectInputStream in = new ObjectInputStream(standingIn);
//            anotherTest = (Standings) in.readObject();
//            in.close();
//            standingIn.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println("Standings class not found");
//            e.printStackTrace();
//            return;
//        }
//        System.out.println("Another deserialization...");
//        System.out.println("Name is: " + anotherTest.getName());
//        System.out.println("Standings now : ");
//        anotherTest.printStandings();
//        Game testGame = new Game(standing.getPlayer("Janne"), standing.getPlayer("Ville"), standing);
//        testGame.startGame();
        TestUI ui = new TestUI(scanner);
        ui.menu();
    }
}
