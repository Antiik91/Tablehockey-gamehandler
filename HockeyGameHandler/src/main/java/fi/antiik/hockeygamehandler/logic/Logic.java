/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import fi.antiik.hockeygamehandler.gui.GUI;
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
    private GUI gui;
    
    public Logic(Referee referee, Timer timer) {
        this.referee = referee;
        this.timer = timer;
        this.elapsedTime = 0L;
    }
    public Logic(String player1, String player2, Standings standings, GUI gui) {
        this.referee = new Referee(standings.getPlayer(player1), standings.getPlayer(player2), standings);
        this.timer = new Timer(1000, new TimerListener(this));
        this.gui = gui;
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
        this.timer.start();
    }
    
    public void addScore(Player player) {
        
    }
    
    public Timer getTime() {
        return this.timer;
    }
    
    public void setTime() {
        this.gui.getTimeField().setText(this.timer.getActionCommand() + " Sets ");
    }
    
    public boolean timeNotZero() {
        if(elapsedTime < 1 * 10*1000) {
            elapsedTime = (new Date()).getTime()- startTime;
            return  true;
        }
    return false;
}
}
