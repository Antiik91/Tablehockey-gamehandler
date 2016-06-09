/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class GUI_old implements Runnable {

    private JFrame frame;

    public GUI_old() {
    }

    @Override
    public void run() {
        frame = new JFrame("Table hockey gamehandler");
        frame.setPreferredSize(new Dimension(500, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        JButton selectStandings = new JButton("Select standings");
        selectStandings.setPreferredSize(new Dimension(400, 100));
        JButton addPlayertoStandings = new JButton("Add Player");
        JButton newGame = new JButton("New game");
        JButton standings = new JButton("Show Standings");
        JButton quit = new JButton("Quit");

        container.setLayout(layout);
        container.add(selectStandings);
        container.add(addPlayertoStandings);
        container.add(newGame);
        container.add(standings);
        container.add(quit);

    }

    public JFrame getFrame() {
        return frame;
    }

}
