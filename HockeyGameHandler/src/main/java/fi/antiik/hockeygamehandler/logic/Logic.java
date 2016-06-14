/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.gui.TimerListener;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author janantik
 */
public class Logic {
    private Referee referee;
    private Timer timer;
    private long startTime;
    private long elapsedTime;
    
    public Logic(Referee referee, Timer timer) {
        this.referee = referee;
        this.timer = timer;
        this.elapsedTime = 0L;
    }
    public Logic(String player1, String player2, Standings standings) {
        this.referee = new Referee(standings.getPlayer(player1), standings.getPlayer(player2), standings);
        this.timer = new Timer(0, new TimerListener(this));
    }
    public Referee getReferee() {
        return this.referee;
    }
    public void setReferee(Referee referee) {
        this.referee = referee;
    }
    
    public void startGame() {
        this.referee.startGame();
        this.startTime = System.currentTimeMillis();
    }
    
    public void addScore(Player player) {
        
    }
    
    public Timer getTime() {
        return this.timer;
    }
    
    public Timer setTime() {
        return timer;
    }
    
    public boolean timeNotZero() {
        if(elapsedTime < 1 * 60*1000) {
            elapsedTime = (new Date()).getTime()- startTime;
            return  true;
        }
    return false;
}
}
