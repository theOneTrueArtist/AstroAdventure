package sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/* skjønne ikke keffor importane mine ikke fungere*/
/* har snakka med gruppe leder og har prøv frem og tilbake. Har viska vekk kode som jeg har gjort.
Muligens ikke så bra da dere ikke får se hva jeg har gjort. Jeg har forsatt tid og kommer til å klare det*/


public class SoundTrack {

    private MediaPlayer mediaPlayer;
    private Clip clip;

    public SoundTrack(String audioFile) {
        Media sound = new Media(getClass().getResource(("pl4y1ng.mp3") + audioFile.toString()));
        mediaPlayer = new MediaPlayer(sound);



    }

    {

    }   /* A block of code that can take inn a audio file, need to find a fitting sound, second one uses
     javax. This was wrong use same format as the application.
    */


    public void stop() {
        mediaPlayer.stop();


        public void loop() {
            mediaPlayer.setCycleCount(mediaPlayer.indefinite);
            mediaPlayer.paly();
        }

    }
}
