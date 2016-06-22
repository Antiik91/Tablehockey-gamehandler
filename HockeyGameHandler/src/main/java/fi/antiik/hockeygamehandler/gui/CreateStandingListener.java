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
 * Class listens create standings button and sets gui's current standings.
 *
 *
 * this new standing that is created when typed in JTextField source.
 *
 * @author janantik
 *
 * @version 0.5
 *
 * @since 0.5
 *
 *
 */
public class CreateStandingListener implements ActionListener {

    private JTextField source;
    private JTextField target;
    private GUI gui;
    private Standings standings;

    /**
     * Creates a new Standings and sets it to current standings to be used.
     *
     * @param standing Gui's standings
     * @param source JtextField to get name of the Standings
     * @param target Main menus Current standings text field
     * @param gui GUI currently used
     */
    public CreateStandingListener(Standings standing, JTextField source, JTextField target, GUI gui) {
        this.source = source;
        this.target = target;
        this.standings = standing;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.source.getText().isEmpty() || this.source.getText().equals("")) {
            this.standings = new Standings("Unnamed Standings");
            this.target.setText("Unnamed Standings");
        } else {
            this.standings = new Standings(this.source.getText());
            this.target.setText(this.source.getText());
        }
        
        this.gui.setCurrentStandings(this.standings);
    }

}
