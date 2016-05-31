/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.testUI;

import fi.antiik.hockeygamehandler.logic.*;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author janantik
 */
public class TestUI {

    private Scanner scanner;
    private Standings standings;
    DataStorage dataStorage;

    public TestUI(Scanner scanner) {
        this.scanner = scanner;
        this.dataStorage = new DataStorage();
    }

    public void menu() {
        while(true) {
        printInstructions();
        int command = getCommand();
        execute(command);
        }

    }

    private void execute(int command) {

        switch (command) {
            case 1:
                selectStandings();
                break;
            case 2:
                addPlayer();
                break;
            case 3:
                startGame();
                break;
            case 4:
                printStandings();
                break;
            case 5:
                storeStandings();
                break;
            case 6:
                quit();
                break;

            default:
                System.out.println("Invalid command");
                printInstructions();
                break;
        }
      
    }

    private void printInstructions() {
        System.out.println("1: Select standings to be used");
        System.out.println("2: Add Player to standings");
        System.out.println("3: Start game");
        System.out.println("4: Print standings");
        System.out.println("5: Store standings");
        System.out.println("6: Quit");
    }

    private void selectStandings() {
        System.out.println("Type 1 to create new Standings and 2 to load existing standing");
        int selection = scanner.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Enter name of the standings: ");
                String nameOfStandings = scanner.nextLine();
                standings = new Standings(nameOfStandings);
                break;
            case 2:
                loadStandings();
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    private void addPlayer() {
        if (standings != null) {
            System.out.println("Name of the player: ");
            String name = scanner.nextLine();
            standings.addPlayer(name);
        } else {
            System.out.println("No standing selected!");
        }
    }

    private void startGame() {
        Player one;
        Player two;
        System.out.println("Player one: ");
        String playerOne = scanner.nextLine();
        if (!standings.standingsContainsPlayer(playerOne)) {
            System.out.println("There is no player " + playerOne);
            standings.addPlayer(playerOne);
            System.out.println(playerOne + " added to the standings");
        }
        one = standings.getPlayer(playerOne);
        System.out.println("Player two: ");
        String playerTwo = scanner.nextLine();
        if (!standings.standingsContainsPlayer(playerTwo)) {
            System.out.println("There is no player " + playerTwo);
            standings.addPlayer(playerTwo);
            System.out.println(playerTwo + " added to the standings");
        }
        two = standings.getPlayer(playerTwo);
        Game game = new Game(one, two, standings, scanner);
        game.startGame();
    }

    private void printStandings() {
        if (standings == null) {
            System.out.println("No standing selected");
        } else {
            standings.printStandings();
        }
    }

    private void storeStandings() {
        if (standings == null) {
            System.out.println("No standing selected");
        } else {
            dataStorage.saveData(standings);
        }

    }

    private void loadStandings() {
        System.out.println("Please write the path to standings.ser");
        System.out.println("for example: ./src/tmp/WorldCup.ser");
        String filePath = scanner.nextLine();
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            standings = (Standings) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Standings class not found");
            c.printStackTrace();
            return;
        }
    }

    private void quit() {
        System.out.println("Program is shutting down...");
        System.exit(0);
    }

    private int getCommand() {
        System.out.println("Command: ");
        return scanner.nextInt();
    }

}
