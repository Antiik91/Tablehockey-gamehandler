/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import fi.antiik.hockeygamehandler.logic.MainLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author janantik
 */
public class StartTimerListener implements ActionListener{
    MainLogic logic;

    public StartTimerListener(MainLogic logic) {
        this.logic = logic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.logic.startGame();
    }
    
}
