
package fi.antiik.hockeygamehandler.logic;

import java.util.Scanner;

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
        
    }
    
    
    public void results() {
        
    }
}
