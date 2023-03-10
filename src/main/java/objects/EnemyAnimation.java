package objects;

import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class EnemyAnimation {
    
    
    public static Image getSprite(EnemyState state,int frame) {
        switch (state) {
            case jump:
                return ImageLoader.getImage("/sprites/other_assets/Alien/jump/Alien_jump_0"+frame/28 %6+".png");
            case run:
                return ImageLoader.getImage("/sprites/other_assets/Alien/run/Alien_run_0"+frame/28 %6+".png");
            case dead:
                return ImageLoader.getImage("/sprites/other_assets/Alien/death/Alien_death_0"+frame/28 %4+".png");
            default:
                return ImageLoader.getImage("/sprites/other_assets/Alien/idle/Alien_idle_0"+frame/28 %4+".png");
        }
    }
}
