package fi.antiik.hockeygamehandler.filehandler;

import fi.antiik.hockeygamehandler.logic.Standings;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataStorage implements Serializable {

    public DataStorage() {
    }

    public static void saveData(Standings standings) {
        if (standings == null) {
            throw new IllegalArgumentException("Standings can't be null!");
        } else {
            String standingsName = "./src/tmp/" + standings.getName() + ".ser";
            try {
                FileOutputStream standingsOut = new FileOutputStream(standingsName);
                ObjectOutputStream out = new ObjectOutputStream(standingsOut);
                out.writeObject(standings);
                out.close();
                standingsOut.close();
//            System.out.println("The standings is saved in /tmp/"
//                    + standingsName + ".ser");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}