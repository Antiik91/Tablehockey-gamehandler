/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import fi.antiik.hockeygamehandler.logic.Logic;
import fi.antiik.hockeygamehandler.logic.Updatable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * Listens actions fired from Swing Timer and use list of Updatable's to update
 * them when Timer wants.
 *
 * @author User
 */
public class TimerListener implements ActionListener {

    private ArrayList<Updatable> updatables;

    /**
     * Listener get List of Updatable's and updates them every time action is
     * performed.
     *
     * @param updatables ArrayList of updatables
     */
    public TimerListener(ArrayList<Updatable> updatables) {

        this.updatables = updatables;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.updatables.isEmpty()) {
            for (Updatable updatableClass : this.updatables) {
                updatableClass.update();
                
            }
        }

    }

}
