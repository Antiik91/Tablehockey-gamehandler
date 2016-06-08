/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import fi.antiik.hockeygamehandler.filehandler.StandingsList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;

/**
 *
 * @author janantik
 */
public class SelecStandingsFromListListener implements ActionListener {

    private JList jlist;
    private StandingsList standingsList;
    private SelectStandings selectStandings;

    public SelecStandingsFromListListener(JList jlist, StandingsList standingList, SelectStandings selectStandings) {
        this.jlist = jlist;
        this.standingsList = standingList;
        this.selectStandings = selectStandings;
    }


    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        selectStandings.setGUIStandings(standingsList.searchStandingsWithName(this.jlist.getSelectedValue().toString()));
        this.selectStandings.updateGUIStandings();
    }

}
