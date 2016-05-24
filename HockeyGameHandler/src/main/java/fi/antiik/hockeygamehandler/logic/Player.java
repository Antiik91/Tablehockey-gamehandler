/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import java.util.Objects;

public class Player implements Comparable<Player>{

    private String name;
    private int gamesPlayed;
    private int won;
    private int losts;
    private int ties;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int winPrecentage;

    public Player(String name) {


    }
//  ******************************* Getters and Setters *****************************

    public String getName() {
        return name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        if (gamesPlayed >= 0) {
            this.gamesPlayed = gamesPlayed;
        }
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        if (won >= 0) {
            this.won = won;
        }
    }

    public int getLosts() {
        return losts;
    }

    public void setLosts(int losts) {
        if (losts >= 0) {
            this.losts = losts;
        }
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        if (ties >= 0) {
            this.ties = ties;
        }
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        if (points >= 0) {
            this.points = points;
        }
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        if (goalsFor >= 0) {
            this.goalsFor = goalsFor;
        }
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        if (goalsAgainst >= 0) {
            this.goalsAgainst = goalsAgainst;
        }
    }

    public int getWinPrecentage() {
        this.winPrecentage = (this.won * 100)/this.gamesPlayed;
        return winPrecentage;
    }

    // *************************************************************************************
   
    /* addGame adds player stats from a game, and handling the points. if the player
       scored more goals than his opponent it resulst a win, and it will add 3 points.
       if scored less then a loss count is increased
       and if the game is tie, one point is added
    */
    public void addGame(int goalsFor, int goalsAgainst) {
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
        this.gamesPlayed++;
        if (goalsFor > goalsAgainst) {
            this.won++;
            this.points += 3;
        } else if (goalsFor < goalsAgainst) {
            this.losts++;
        } else {
            this.ties++;
            this.points++;
        }

    }
    @Override
    public String toString(){
        return this.name;
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
        if(this.points > o.points) return -1;
        if( this.points == o.points){
            if(this.won > o.won) return -1;
            if(this.won == o.won){
                if(this.goalsFor > o.goalsFor) return -1;
                if(this.goalsFor == o.goalsFor) return 0;
            }
        }
        
        return 1;
    }


    
}
