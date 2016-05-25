package fi.antiik.hockeygamehandler.logic;


/**
 *
 * @author janantik
 */
import java.io.Serializable;
import java.util.*;

public class Standings implements Serializable {

    private ArrayList<Player> standings;
    private String name;

    public Standings(String name) {
        this.name = name;
        this.standings = new ArrayList<Player>();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return standings.size();
    }

    public ArrayList<Player> getStandings() {
        if (!standings.isEmpty()) {
            Collections.sort(standings);
        }
        return this.standings;
    }
    
    public void printStandings(){
        Collections.sort(standings);
        System.out.println("Name Games Wins Losses Ties GoalsFor GoalsAgainst Win% Points");
        for (Player player : standings) {
            System.out.println(player);
        }
    }

    public void addPlayer(String name) {
        if (!standingsContainsPlayer(name)) {
            this.standings.add(new Player(name));
        } else {
            System.out.println("Player is in the standings already!");
        }
    }

    public Player getPlayer(String name) {
        for (Player player : standings) {
            if (name.toLowerCase().equals(player.getName().toLowerCase())) {
                return player;
            }
        }
        return null;
    }

    public boolean standingsContainsPlayer(String name) {
        if (this.standings.isEmpty()) {
            return false;
        }
        boolean found = false;
        for (Player player : standings) {
            if (name.toLowerCase().equals(player.getName().toLowerCase())) {
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
