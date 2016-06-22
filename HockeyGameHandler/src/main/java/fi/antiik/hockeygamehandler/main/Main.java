/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.main;

//import fi.antiik.hockeygamehandler.filehandler.FileLoader;
import fi.antiik.hockeygamehandler.gui.GUI;
import fi.antiik.hockeygamehandler.gui.GUI_old;
import fi.antiik.hockeygamehandler.logic.*;
import fi.antiik.hockeygamehandler.testuserinterface.TestUI;
import fi.antiik.hockeygamehandler.logic.Referee;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

import java.util.*;
import static javafx.scene.input.DataFormat.URL;
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
//            FileLoader lo = new FileLoader("Hello");
//            
//            List<String> names = new ArrayList<>();
//            try {
//              names = lo.getResourceFiles("./src/tmp/");  
//            } catch(Exception e) {
//                System.out.println("Ei toimi :( ");
//            }
//            
//            for (String name : names) {
//                System.out.println(name);
        
//        TestUI ui = new TestUI(scanner);
//        ui.menu();
URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(location.getFile());
        String path = System.getProperties().getProperty("java.class.path");
        File lol = new File(path + "/saved_files");
        for (String arg : lol.list()) {
            System.out.println(arg);
        }
        System.out.println(lol.isDirectory());
    }
}
