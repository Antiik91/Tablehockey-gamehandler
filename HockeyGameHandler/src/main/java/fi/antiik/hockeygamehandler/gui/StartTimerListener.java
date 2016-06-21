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
 * Class tells logic to start game when start button is pressed.
 *
 * @author janantik
 */
public class StartTimerListener implements ActionListener {

    Logic logic;

    /**
     * When button is pressed, logic starts the game created.
     *
     * @param logic logic to be started.
     */
    public StartTimerListener(Logic logic) {
        this.logic = logic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.logic.startGame(10);
    }

}
