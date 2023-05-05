package sound;

import java.io.File;



import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class SoundTrack {

    private String songFile = "src/main/resources/pl4y1ng.mp3";
    private MediaPlayer mediaPlayer;

    public SoundTrack() {

        
        try{
            File musicPath = new File(songFile);

            String sl = musicPath.toURI().toString();
            if(sl != null){

                Media sound = new Media(sl);
                mediaPlayer = new MediaPlayer(sound);

            } else {
                System.out.println("Cant find file");
            }

        } catch(Exception e){
            System.out.println("ERROR: Something is wrong with the Sound track");
            System.out.println(e);
        }
        }

    public void play(){
        mediaPlayer.play();
        }

    public void stop() {
        mediaPlayer.stop();
    }

    public void pause(){
        mediaPlayer.pause();;
    }

    public void loop(){
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

}
