package sound;
import javafx.sound.*;

public class SoundTrack {
    private Clip clip;

    public SoundTrack(String audioFile) {

        URL url = getClass().getResource(("") + audioFile);
        AudioInputStream audioInputStream = audioSystem.getaudioInputStream(url);
        clip = Audiosyste.getClip();
        clip.open(audioInputStream);
        }
    {

    }   // A block of code that can take inn a audio file, need to find a fitting sound, by using URL


    public void play(){
        if (clip != null && !clip.isRunning()) {
            clip.start();
            }
        }
        public void stop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

    }

}
