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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author User
 */
public class standingsListTest {
    
    StandingsList list;
    
    public standingsListTest() {
    }
    
    @Before
    public void setUp() {
        list = new StandingsList();
    }
    
    public ArrayList<File> getFiles(String path) {
        File folder = new File(path);
        File[] filesList = folder.listFiles();
        ArrayList<File> testFiles = new ArrayList<>();
        
        for (int i = 0; i < filesList.length; i++) {
            if (filesList[i].isFile()) {
                testFiles.add(filesList[i]);
            }
        }
        return testFiles;
    }
    
    @Test
    public void ListOfFilesWorks() {
        ArrayList<File> testFiles = getFiles("src/tmp");
        assertEquals(testFiles, list.getFilesFromFolder());
        
    }
    
    @Test
    public void standingsAreCorrect() {
        ArrayList<File> files = getFiles("src/tmp");
        ArrayList<Standings> compareList = new ArrayList<>();
        for (File file : files) {
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Standings standings = (Standings) in.readObject();
                compareList.add(standings);
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
        assertEquals(compareList.contains("TestStanding"), list.getStandings().contains("TestStanding"));
    }
    
}
