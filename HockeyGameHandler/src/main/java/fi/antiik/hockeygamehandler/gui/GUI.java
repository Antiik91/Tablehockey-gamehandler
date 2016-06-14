/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import fi.antiik.hockeygamehandler.filehandler.DataStorage;
import fi.antiik.hockeygamehandler.filehandler.StandingsList;
import fi.antiik.hockeygamehandler.logic.Logic;
import fi.antiik.hockeygamehandler.logic.Player;
import fi.antiik.hockeygamehandler.logic.Referee;
import fi.antiik.hockeygamehandler.logic.Standings;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author janantik
 *
 * @version 0.5
 *
 * @since 0.4
 *
 * Class is first presented when user starts the program. it shows graphical
 * user interface
 */
public class GUI extends javax.swing.JFrame {

    private Standings currentStandings;
    private JTextField timeField;

    public void setCurrentStandings(Standings currentStandings) {
        this.currentStandings = currentStandings;
    }

    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selecStandingsButton = new javax.swing.JButton();
        addPlayerButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();
        saveStandingsButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        currentStandingTextField = new javax.swing.JTextField();
        showStandingsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selecStandingsButton.setText("Select Standings");
        selecStandingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecStandingsButtonActionPerformed(evt);
            }
        });

        addPlayerButton.setText("Add Player");
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });

        newGameButton.setText("New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        saveStandingsButton.setText("Save Standings");
        saveStandingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStandingsButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("   Current Standing");

        currentStandingTextField.setEditable(false);
        if(currentStandings != null) {
            currentStandingTextField.setText(currentStandings.getName());
        }

        showStandingsButton.setText("Show Standings");
        showStandingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showStandingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(selecStandingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPlayerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveStandingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentStandingTextField)
                    .addComponent(showStandingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentStandingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(selecStandingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPlayerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newGameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showStandingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveStandingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitButton)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        if (this.currentStandings != null) {
            String player1 = (String) JOptionPane.showInputDialog("Player 1:");
            String player2 = (String) JOptionPane.showInputDialog("Player 2: ");
            Logic logic = new Logic(player1, player2, this.currentStandings, this);
            //MainLogic logic = new MainLogic(3,new Timer(0, new TimerListener()), new Referee(currentStandings.getPlayer(player1), currentStandings.getPlayer(player2), currentStandings));
            JFrame frame = new JFrame("New Game");
            frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
            frame.setPreferredSize(new Dimension(800, 400));
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panel.setLayout(new BorderLayout());
            this.timeField  = new JTextField();
            panel.add(timeField);
            JLabel playerOne = new JLabel(player1);
            JLabel playerTwo = new JLabel(player2);
            JButton startButton = new JButton("Start");
            startButton.addActionListener(new StartTimerListener(logic));
            frame.setContentPane(panel);
            frame.add(startButton, BorderLayout.SOUTH);
            frame.add(playerOne, BorderLayout.WEST);
            frame.add(playerTwo, BorderLayout.EAST);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);

            timeField.setText(logic.getTime().toString());

        }

    }//GEN-LAST:event_newGameButtonActionPerformed
        public JTextField getTimeField() {
            return this.timeField;
        }
    
    /**
     * Updates the current standings textfield to show current standings name
     */
    public void updateCurrentStandings() {
        currentStandingTextField.setText(this.currentStandings.getName());
    }
    private void selecStandingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecStandingsButtonActionPerformed

        JFrame frame = new JFrame("Select standings");

        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);

        JPanel contentPane = new JPanel();

        contentPane.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        SelectStandings ss = new SelectStandings(currentStandings, currentStandingTextField, this, frame);
        frame.setContentPane(ss);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);


    };//GEN-LAST:event_selecStandingsButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerButtonActionPerformed

        if (this.currentStandings != null) {
//            JFrame frame = new JFrame("Add Player to standings");
//            frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
//
//            JPanel content = new JPanel();
//
//            content.setBorder(
//                    BorderFactory.createEmptyBorder(5, 5, 5, 5));
//            content.setLayout(new BorderLayout());
//
//            JTextField newPlayer = new JTextField();
//            content.add(newPlayer, BorderLayout.NORTH);
//
//            JButton newPlayerButton = new JButton("Create Player");
//            newPlayerButton.addActionListener(new AddPlayerListener(newPlayer, currentStandings));
//            content.add(newPlayerButton, BorderLayout.SOUTH);
//
//            frame.setContentPane(content);
//            frame.pack();
//            frame.setLocationByPlatform(true);
//            frame.setVisible(true);
            String newPlayer = (String) JOptionPane.showInputDialog("Add a new player to standings: \n ");
            this.currentStandings.addPlayer(newPlayer);

        }
    }//GEN-LAST:event_addPlayerButtonActionPerformed

    private void saveStandingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveStandingsButtonActionPerformed
        if (this.currentStandings != null) {
            DataStorage.saveData(currentStandings);
        }
    }//GEN-LAST:event_saveStandingsButtonActionPerformed
    private int getStandingsSize() {
        return this.currentStandings.getPlayers().size();
    }
    private void showStandingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showStandingsButtonActionPerformed
        if (this.currentStandings != null) {
            JFrame frame = new JFrame("Standings ");
            frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
            frame.setPreferredSize(new Dimension(800, 400));

            JPanel panel = new JPanel();

            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panel.setLayout(new GridLayout(getStandingsSize() + 1, 10));
            panel.add(new JLabel(" Place "));
            panel.add(new JLabel(" Name "));
            panel.add(new JLabel(" Games Played "));
            panel.add(new JLabel(" Wins "));
            panel.add(new JLabel(" Loss "));
            panel.add(new JLabel(" Ties "));
            panel.add(new JLabel(" Goals For"));
            panel.add(new JLabel(" Goals Against "));
            panel.add(new JLabel(" Win% "));
            panel.add(new JLabel(" Points "));
            int index = 1;
            for (Player player : currentStandings.getPlayers()) {
                panel.add(new JLabel(" " + index));
                panel.add(new JLabel(" " + player.getName()));
                panel.add(new JLabel(" " + player.getGamesPlayed()));
                panel.add(new JLabel(" " + player.getWins()));
                panel.add(new JLabel(" " + player.getLosses()));
                panel.add(new JLabel(" " + player.getTies()));
                panel.add(new JLabel(" " + player.getGoalsFor()));
                panel.add(new JLabel(" " + player.getGoalsAgainst()));
                panel.add(new JLabel(" " + player.getWinPrecentage()));
                panel.add(new JLabel(" " + player.getPoints()));
                index++;
            }
            frame.setContentPane(panel);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);

        }
    }//GEN-LAST:event_showStandingsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JTextField currentStandingTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton saveStandingsButton;
    private javax.swing.JButton selecStandingsButton;
    private javax.swing.JButton showStandingsButton;
    // End of variables declaration//GEN-END:variables
}
