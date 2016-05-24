package fi.antiik.hockeygamehandler.logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author janantik
 */
import java.util.*;

public class Standings {

    private ArrayList<Player> standings;
    private String name;

    public Standings(String name) {
        this.name = name;
        this.standings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getStandings() {
        if(!standings.isEmpty()){
        Collections.sort(standings);
        }
        //Collections.reverse(standings);
        return this.standings;
    }

    public void addPlayer(Player player) {
        if (!standingsContainPlayer(player.getName())) {
            this.standings.add(player);
        } else {
            System.out.println("Player is in the standings already!");
        }
    }

    public boolean standingsContainPlayer(String name) {
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
