package enemy;

import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class EnemyAnimation {

    /**
     * gets a sprite image for the enemy given
     * @param state
     * @param frame
     * @return image sprite
     */
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
