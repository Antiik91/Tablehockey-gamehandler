package fi.antiik.hockeygamehandler.logic;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class contains information about Player and it's statistics.
 *
 * @author janantik
 *
 * @version 0.5
 *
 * @since 0.01
 *
 *
 */
public class Player implements Comparable<Player>, Serializable {

    private String name;
    private int gamesPlayed;
    private int wins;
    private int losses;
    private int ties;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int winPrecentage;

    /**
     * Creates a new Player with given name.
     *
     * @param name name to be given player.
     */
    public Player(String name) {
        this.name = name;

    }
//  ******************************* Getters and Setters *****************************

    /**
     * Returns name of the player.
     *
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns played games.
     *
     * @return games played
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * sets the games played with new games if the given parameter is greater
     * than zero.
     *
     * @param gamesPlayed number of games played to be set
     */
    public void setGamesPlayed(int gamesPlayed) {
        if (gamesPlayed >= 0) {
            this.gamesPlayed = gamesPlayed;
        }
    }

    /**
     * Returns Wins.
     *
     * @return Wins player has
     */
    public int getWins() {
        return wins;
    }

    /**
     * Sets wins if not less than zero.
     *
     * @param wins wins to be set
     */
    public void setWins(int wins) {
        if (wins >= 0) {
            this.wins = wins;
        }
    }

    /**
     * returns losses.
     *
     * @return losses player has
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Sets losses if they are more than zero.
     *
     * @param losses losses to be set
     */
    public void setLosses(int losses) {
        if (losses >= 0) {
            this.losses = losses;
        }
    }

    /**
     * Get ties.
     *
     * @return Number of ties player has played
     */
    public int getTies() {
        return ties;
    }

    /**
     * Sets ties if not negative.
     *
     * @param ties number of ties to be sete
     */
    public void setTies(int ties) {
        if (ties >= 0) {
            this.ties = ties;
        }
    }

    /**
     * Points player has.
     *
     * @return number of points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets points if not negative.
     *
     * @param points points to be set
     */
    public void setPoints(int points) {
        if (points >= 0) {
            this.points = points;
        }
    }

    /**
     * Number of goals Player has made.
     *
     * @return number of goals
     */
    public int getGoalsFor() {
        return goalsFor;
    }

    /**
     * Set Goals made.
     *
     * @param goalsFor New number of goals if not negative
     */
    public void setGoalsFor(int goalsFor) {
        if (goalsFor >= 0) {
            this.goalsFor = goalsFor;
        }
    }

    /**
     * Number of goals player has been scored against.
     *
     * @return Number of goals scored against
     */
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    /**
     * Set Goals against if not negative.
     *
     * @param goalsAgainst goals to be set
     */
    public void setGoalsAgainst(int goalsAgainst) {
        if (goalsAgainst >= 0) {
            this.goalsAgainst = goalsAgainst;
        }
    }

    /**
     * Method counts win precentage of a player by dividing played games with
     * wins.
     *
     * @return counted winprecentage
     */
    public int getWinPrecentage() {
        if (this.gamesPlayed == 0) {
            return 0;
        }
        this.winPrecentage = (this.wins * 100) / this.gamesPlayed;
        return winPrecentage;
    }

    // *************************************************************************************
    /**
     * addScores adds player stats from a game, and handling the points. if the
     * player scored more goals than it's opponent result is a win, and it will
     * add 3 points. if scored less than it's opponent then a loss count is increased and if the
     * game is tie, one point is added.
     *
     * @param goalsFor goals that Player has scored
     *
     * @param goalsAgainst goals that other player has scored against player
     */
    public void addScores(int goalsFor, int goalsAgainst) {
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
        this.gamesPlayed++;
        if (goalsFor > goalsAgainst) {
            this.wins++;
            this.points += 3;
        } else if (goalsFor < goalsAgainst) {
            this.losses++;
        } else {
            this.ties++;
            this.points++;
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!this.name.equals(other.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Player o) {
        if (this.points > o.points) {
            return -1;
        }
        if (this.points == o.points) {
            if (this.wins > o.wins) {
                return -1;
            }
            if (this.wins == o.wins) {
                if (this.goalsFor > o.goalsFor) {
                    return -1;
                }
                if (this.goalsFor == o.goalsFor) {
                    if (this.gamesPlayed > o.gamesPlayed) {
                        return -1;
                    }

                    return 0;
                }
            }
        }

        return 1;
    }

    @Override
    public String toString() {
        return this.name + " " + this.gamesPlayed + " " + this.wins + " " + this.losses + " " + this.ties + " "
                + this.goalsFor + " " + this.goalsAgainst + " " + getWinPrecentage() + " " + this.points;
    }
}
