/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import fi.antiik.hockeygamehandler.logic.Logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class TimerListener implements ActionListener{
    private boolean continues;
    private Logic logic;

    public TimerListener(Logic logic) {
        this.continues = continues;
        this.logic = logic;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        while (logic.timeNotZero()) {
                   logic.setTime();
        }
    }
    
}
