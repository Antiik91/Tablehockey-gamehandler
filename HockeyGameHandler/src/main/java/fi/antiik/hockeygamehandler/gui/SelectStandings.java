/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.gui;

import fi.antiik.hockeygamehandler.filehandler.StandingsList;
import fi.antiik.hockeygamehandler.logic.Standings;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionListener;
import static java.lang.Math.E;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author janantik
 *
 * @version 0.5
 *
 * @since 0.5 class creates JPanel which contains list of standings in
 * standingsList and possibility to create new standings.
 */
public class SelectStandings extends javax.swing.JPanel {

    /**
     * Creates new form SelectStandings
     */
    private StandingsList standingsList;
    private Standings standings;
    private JTextField textField;
    private GUI gui;
    private Frame frame;
    
    public SelectStandings(Standings standings, JTextField textField, GUI gui, Frame frame) {
        this.standings = standings;
        standingsList = new StandingsList();
        this.textField = textField;
        this.gui = gui;
        this.frame = frame;
        initComponents();
        setVisible(true);
    }
    
    private String[] updateList() {
        int listSize = this.standingsList.getStandings().size();
        String[] listData = new String[listSize];
        for (int i = 0; i < listSize; i++) {
            listData[i] = this.standingsList.getStandings().get(i).getName();
        }
        this.standingsJList.setListData(listData);
        return listData;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        createNewStandingsField = new javax.swing.JTextField();
        selectStandingsButton = new javax.swing.JButton();
        createStandingsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        standingsJList = new javax.swing.JList<String>();

        jLabel1.setText("Select a standing from a list or create a new one");

        createNewStandingsField.setText("");

        selectStandingsButton.addActionListener(new SelecStandingsFromListListener(this.standingsJList, standingsList, this));
        selectStandingsButton.setText("Select");
        selectStandingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectStandingsButtonActionPerformed(evt);
            }
        });

        createStandingsButton.setText("Create");
        CreateStandingListener copier = new CreateStandingListener(this.standings, createNewStandingsField, textField, this.gui);
        createStandingsButton.addActionListener(copier);
        createStandingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStandingsButtonActionPerformed(evt);
            }
        });

        standingsJList.setModel(new javax.swing.AbstractListModel<String>() {

            String[] strings = updateList();

            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(standingsJList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createNewStandingsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createStandingsButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectStandingsButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createNewStandingsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createStandingsButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(selectStandingsButton)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createStandingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStandingsButtonActionPerformed
        this.frame.setVisible(false);
        

    }//GEN-LAST:event_createStandingsButtonActionPerformed

    private void selectStandingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectStandingsButtonActionPerformed
        this.frame.setVisible(false);
    }//GEN-LAST:event_selectStandingsButtonActionPerformed
    
    public Standings getStandings() {
        return standings;
    }

    /**
     * updates currentStandings found in GUI
     */
    public void updateGUIStandings() {
        this.gui.updateCurrentStandings();
    }

    /**
     * Sets currentStandings found in GUI
     *
     * @param standings GUI's standings
     */
    public void setGUIStandings(Standings standings) {
        this.gui.setCurrentStandings(standings);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField createNewStandingsField;
    private javax.swing.JButton createStandingsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selectStandingsButton;
    private javax.swing.JList<String> standingsJList;
    // End of variables declaration//GEN-END:variables
}
