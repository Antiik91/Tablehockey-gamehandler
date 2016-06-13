package fi.antiik.hockeygamehandler.logic;

/**
 *
 * @author janantik
 *
 * @version 0.5
 *
 * since 0.01
 *
 * Class stores Players in standings and sorts them in correct order
 *
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

    /**
     * Method checks if Arralist is not empty before sorting it in order
     *
     * @return Arraylist of standings
     */
    public ArrayList<Player> getPlayers() {
        if (!standings.isEmpty()) {
            Collections.sort(standings);
        }
        return this.standings;
    }

    /**
     * Adds player to the standings if it's not already in there
     *
     * @param name name of the player to be added (user input)
     */
    public void addPlayer(String name) {
        if (!standingsContainsPlayer(name)) {
            this.standings.add(new Player(name));
        } else {
            System.out.println("Player is in the standings already!");
        }
    }

    /**
     * Checks if the player is in the standings and if it is, return Player by
     * it's name
     *
     * @param name name of the player to be searched (user input)
     *
     * @return Player named by param name or null if no player is found.
     */
    public Player getPlayer(String name) {
        for (Player player : standings) {
            if (name.toLowerCase().equals(player.getName().toLowerCase())) {
                return player;
            }
        }
        addPlayer(name);
        return getPlayer(name);
    }

    /**
     * Check if standing contains player.
     *
     * @param name name of the player
     * @return true if found false if not
     */
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
