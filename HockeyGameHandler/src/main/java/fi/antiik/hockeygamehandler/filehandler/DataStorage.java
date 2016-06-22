package fi.antiik.hockeygamehandler.filehandler;

import fi.antiik.hockeygamehandler.logic.Standings;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataStorage implements Serializable {

    /**
     * Class is used to store Standings to be used in future.
     *
     * @author janantik
     *
     */
    public DataStorage() {
    }

    /**
     * Method stores Standings to preselected folder in .ser.
     *
     * @param standings Standings to be stored.
     */
    public static void saveData(Standings standings) {
        if (standings == null) {
            throw new IllegalArgumentException("Standings can't be null!");
        } else {
            String lol = System.getProperties().getProperty("user.dir");
            String standingsName = lol + "/saved_files/" + standings.getName() + ".ser";
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
