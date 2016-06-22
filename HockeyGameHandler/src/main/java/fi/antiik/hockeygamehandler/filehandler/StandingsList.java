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
 * Class lists all available Standings from a folder to arrayList.
 *
 *
 *
 *
 *
 * @author janantik
 *
 *
 *
 */
public class StandingsList {

    private ArrayList<Standings> listOfStandings;

    /**
     * Creates new list of standings.
     */
    public StandingsList() {
        listOfStandings = new ArrayList<>();
    }

    /**
     * Method is used to return standings list.
     *
     * @return ArrayList of standings
     */
    public ArrayList<Standings> getStandings() {
        addStandings();
        return this.listOfStandings;
    }

    /**
     * Searches standings and returns if found.
     *
     * @param name name of the standings to be searched
     * @return Standings if found null else
     */
    public Standings searchStandingsWithName(String name) {
        Standings found;
        for (Standings standings : listOfStandings) {
            if (standings.getName().toLowerCase().equals(name.toLowerCase())) {
                found = standings;
                return found;
            }
        }
        return null;
    }

    /**
     * Searches and returns all the files from folders where Standings are.
     *
     * @return ArrayList of Files
     */
    public ArrayList<File> getFilesFromFolder() {
        String userDir = System.getProperties().getProperty("user.dir");
        
        String standingsName = userDir + "/saved_files/";
        File folder = new File(standingsName);
        File[] filesList = folder.listFiles();
        ArrayList<File> files = new ArrayList<>();

        for (int i = 0; i < filesList.length; i++) {
            if (filesList[i].isFile()) {
                files.add(filesList[i]);
            }
        }

        return files;
    }

    /**
     * gets the files from folder and changes them to Standings and adds them to
     * arraylist. catch exceptions if file cannot be opened or class inside file
     * is not Standings
     */
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
                //System.out.println("Standings class not found");
                c.printStackTrace();
                return;
            }
        }
    }
}
