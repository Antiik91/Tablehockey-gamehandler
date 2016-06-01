/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.testUI;

import fi.antiik.hockeygamehandler.fileHandling.StandingsList;
import fi.antiik.hockeygamehandler.fileHandling.DataStorage;
import fi.antiik.hockeygamehandler.logic.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author janantik
 */
public class TestUI {

    private Scanner scanner;
    private Standings standings;
    private DataStorage dataStorage;
    private StandingsList loadStandings;
    private ArrayList<Standings> listOfStandings;

    public TestUI(Scanner scanner) {
        this.scanner = scanner;
        this.dataStorage = new DataStorage();
        this.loadStandings = new StandingsList();
        listOfStandings = loadStandings.getStandings();
    }

    public void menu() {
        while (true) {
            printInstructions();
            System.out.print("Command: ");
            int command = scanner.nextInt();
            scanner.nextLine();
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
        //Workaround to get newline char from nextint....
        scanner.nextLine();
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
            String name = scanner.next();
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
        Game game = new Game(one, two, standings);
        game.startGame();

        updateResults(game);
    }

    private void updateResults(Game game) {
        System.out.println("Scores for " + game.getPlayerOne().getName());
        int scoresFor1 = scanner.nextInt();
        System.out.println("Scores for " + game.getPlayerTwo().getName());
        int scoresFor2 = scanner.nextInt();
        game.results(scoresFor2, scoresFor2);
    }

    private void printStandings() {
        if (standings == null) {
            System.out.println("No standing selected");
        } else {
            System.out.println("Name Games Wins Losses Ties "
                    + "GoalsFor GoalsAgainst Win% Points");
            for (Player player : standings.getPlayers()) {
                System.out.println(player);
            }
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
        int index = 0;
        System.out.println("Please select standing from index");
        for (Standings standing : listOfStandings) {
            System.out.println(index + " " + standing);
            index++;
        }
        int getIndex = scanner.nextInt();
        if (getIndex > listOfStandings.size()) {
            System.out.println("Incorrect index.");
        } else {
            standings = listOfStandings.get(getIndex);
        }

    }

    private void quit() {
        System.out.println("Program is shutting down...");
        System.exit(0);
    }

}
