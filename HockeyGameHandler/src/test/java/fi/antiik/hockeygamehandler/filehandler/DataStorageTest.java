/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.filehandler;

import fi.antiik.hockeygamehandler.logic.Standings;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class DataStorageTest {

    DataStorage dataStore;
    Standings standing;

    public DataStorageTest() {
    }

    public void setUp() {
        dataStore = new DataStorage();

    }

//    @Test
//    public void dataStoreActuallyStoresData() {
//        standing = new Standings("TestStanding");
//        for (int i = 0; i < 10; i++) {
//            standing.addPlayer("Player " + i);
//        }
//        dataStore.saveData(standing);
//        String usDir = System.getProperties().getProperty("user.dir");
//        String standingsName = usDir + "/saved_files/";
//        File folder = new File(standingsName);
//        File[] filesList = folder.listFiles();
//        ArrayList<File> files = new ArrayList<>();
//
//        for (int i = 0; i < filesList.length; i++) {
//            if (filesList[i].isFile()) {
//                files.add(filesList[i]);
//            }
//        }
//        File testFile = new File("src\\tmp\\" + standing.getName() + ".ser");
//        assertTrue(files.contains(testFile));
//    }

    @Test
    public void nullTest() {
        Standings nullS = new Standings(null);
        Throwable expectedException = null;
        try {
            dataStore.saveData(standing);
        } catch (Throwable exception) {
            expectedException = exception;
        }
        assertTrue(expectedException instanceof IllegalArgumentException);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
