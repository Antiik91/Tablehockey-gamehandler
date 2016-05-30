package fi.antiik.hockeygamehandler.logic;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

    Player one;
    Player two;
    Standings standings;
    Scanner scanner;

    public Game(Player one, Player two, Standings standings) {
        this.one = one;
        this.two = two;
        this.standings = standings;
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Press any key to start: ");
        String anyKey = scanner.nextLine();
        long startingTime = System.currentTimeMillis();
        long elapsedTimeMills = System.currentTimeMillis() - startingTime;
        float elapsedTimeInMinutes = elapsedTimeMills / (60 * 1000F);

    }

    public void results() {

    }
}
