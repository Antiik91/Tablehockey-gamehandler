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
public class CreateStandingListener implements ActionListener{
    private JTextField source;
    private JTextField target;
    private GUI gui;
    private Standings standings;

    public CreateStandingListener(Standings standing, JTextField source, JTextField target, GUI gui) {
        this.source = source;
        this.target = target;
        this.standings = standing;
        this.gui = gui;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        this.target.setText(this.source.getText());
        this.standings = new Standings(this.source.getText());
        this.gui.setCurrentStandings(this.standings);
    }
    
}
