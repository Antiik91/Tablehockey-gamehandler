/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.main;

import fi.antiik.hockeygamehandler.gui.GUI_old;
import fi.antiik.hockeygamehandler.logic.*;
import fi.antiik.hockeygamehandler.testuserinterface.TestUI;
import fi.antiik.hockeygamehandler.logic.Referee;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author janantik
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        GUI_old gui = new GUI_old();
//        SwingUtilities.invokeLater(gui);
        TestUI ui = new TestUI(scanner);
        ui.menu();


    }
}
