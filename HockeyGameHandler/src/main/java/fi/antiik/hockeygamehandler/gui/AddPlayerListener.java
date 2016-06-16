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
 * class listens Addplayer button.
 *
 * It adds player name in JTextField playerName to standings given in parameter
 *
 * @author janantik
 *
 * @version 0.5
 *
 * @since 0.5
 *
 *
 */
public class AddPlayerListener implements ActionListener {

    JTextField playerName;
    Standings currentStandings;

    /**
     * Adds Player in JTextField to standings.
     *
     * @param getStandings JtextField where Player name is placed
     * @param currentStandings Standings where Player is added
     */
    public AddPlayerListener(JTextField getStandings, Standings currentStandings) {
        this.playerName = getStandings;
        this.currentStandings = currentStandings;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentStandings.addPlayer(playerName.getText());
    }

}
