package sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * This class represents the sound track for the game. The song is already set, but pause, play and stop are available.
 */
public class SoundTrack {

    private String songFile = "src/main/resources/pl4y1ng.mp3"; //Path to sound file
    private MediaPlayer mediaPlayer;                            //Mediaplayer



    public SoundTrack() {

        try{
            File musicPath = new File(songFile);

            String sl = musicPath.toURI().toString();

            if(sl != null){

                Media sound = new Media(sl);
                mediaPlayer = new MediaPlayer(sound);

            } else {
                System.out.println("Can't find file");
            }

        } catch(Exception e){
            System.out.println("ERROR: Something is wrong with the Sound track");
            System.out.println(e);
        }
    }


    /**
     * Plays the music, also works to unpause music.
     */
    public void play(){
        mediaPlayer.play();
        }

    /**
     * Stops the music entirely, playing again will result in restarting music.
     */
    public void stop() {
        mediaPlayer.stop();
    }

    /**
     * Pauses the music.
     */
    public void pause(){
        mediaPlayer.pause();
    }
}
