/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import fi.antiik.hockeygamehandler.logic.Standings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class AddPlayerListener implements ActionListener {

    JTextField getStandings;
    Standings currentStandings;

    public AddPlayerListener(JTextField getStandings, Standings currentStandings) {
        this.getStandings = getStandings;
        this.currentStandings = currentStandings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentStandings.addPlayer(getStandings.getText());
    }

}
