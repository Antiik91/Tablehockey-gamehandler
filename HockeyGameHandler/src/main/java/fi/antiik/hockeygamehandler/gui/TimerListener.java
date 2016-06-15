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
 *
 * @author User
 */
public class TimerListener implements ActionListener {

    private ArrayList<Updatable> updatables;

    public TimerListener(ArrayList<Updatable> updatables) {

        this.updatables = updatables;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.updatables.isEmpty()) {
            for (Updatable updatableClass : this.updatables) {
                updatableClass.update();
            }
        }else {
            System.out.println("NOWORKLOL");
        }
        

    }

}
