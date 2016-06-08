/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.filehandler;

import fi.antiik.hockeygamehandler.logic.Standings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author janantik
 */
public class StandingsList {

    private ArrayList<Standings> listOfStandings;

    public StandingsList() {
        listOfStandings = new ArrayList<>();
    }

    public ArrayList<Standings> getStandings() {
        addStandings();
        return this.listOfStandings;
    }
    
    public Standings searchStandingsWithName(String name) {
        Standings found;
        for (Standings standings : listOfStandings) {
            if(standings.getName().toLowerCase().equals(name)) {
                found = standings;
                return found;
            }
        }
        return null;
    }

    public ArrayList<File> getFilesFromFolder() {
        File folder = new File("src/tmp");
        File[] filesList = folder.listFiles();
        ArrayList<File> files = new ArrayList<>();

        for (int i = 0; i < filesList.length; i++) {
            if (filesList[i].isFile()) {
                files.add(filesList[i]);
            }
        }

        return files;
    }

    public void addStandings() {
        ArrayList<File> files = getFilesFromFolder();

        for (File file : files) {
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Standings standings = (Standings) in.readObject();
                listOfStandings.add(standings);
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Standings class not found");
                c.printStackTrace();
                return;
            }
        }
    }
}
