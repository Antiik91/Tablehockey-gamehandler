
package fi.antiik.hockeygamehandler.logic;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Class is used to play sound effects.
 *
 * @author janantik
 */
public class SoundPlayer {

    /**
     * Opens and plays the wav file from filename.
     *
     * @param filename filename where the soundfile is located
     */
    public static void playSound(String filename) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();

        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

    }
}
