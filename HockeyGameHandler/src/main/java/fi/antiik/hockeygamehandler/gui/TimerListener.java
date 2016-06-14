/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import fi.antiik.hockeygamehandler.logic.Logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class TimerListener implements ActionListener {

    private Logic logic;
    private Timer timer;

    public TimerListener(Logic logic) {
        this.logic = logic;
        this.timer = logic.getTime();

        timer.setInitialDelay(0);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!logic.timeNotZero()) {
            this.timer.stop();
        } else {
            logic.setTime();
        }
    }

}
