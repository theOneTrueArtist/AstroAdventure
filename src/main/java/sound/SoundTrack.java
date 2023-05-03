package sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class SoundTrack {

    private MediaPlayer mediaPlayer;
    private Clip clip;

    public SoundTrack(String audioFile) {
        Media sound = new Media(getClass().getResource(("") + audioFile.toString()));
        mediaPlayer = new MediaPlayer(sound);

/


    }

    {

    }   /* A block of code that can take inn a audio file, need to find a fitting sound, second one uses
     javax. This was wrong use same format as the application.
    */


    public void stop() {
        mediaPlayer.stop();


        public void loop () {
            mediaPlayer.setCycleCount(mediaPlayer.indefinite);
            mediaPlayer.paly();
        }

    }
}
