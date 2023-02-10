package player;

import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class PlayerAnimation {

	public static Image getSprite(PlayerState state,int frame) {
		if (PlayerState.run == state)
			return ImageLoader.getImage("/sprites/character/run/adventurer-run-0"+frame/8 %6+".png");
		return ImageLoader.getImage("/sprites/character/idle/adventurer-idle-0"+frame/8 %4+".png");
	}
	
}
