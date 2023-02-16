package player;

import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class PlayerAnimation {

	public static Image getSprite(PlayerState state,int frame) {
		switch (state) {
			case jump:
				return ImageLoader.getImage("/sprites/character/jump/adventurer-crnr-jmp-0"+frame/8 %2+".png");
			case run:
				return ImageLoader.getImage("/sprites/character/run/adventurer-run-0"+frame/8 %6+".png");
			case fall:
				return ImageLoader.getImage("/sprites/character/fall/adventurer-fall-0"+frame/8 %2+".png"); 
			default:
				return ImageLoader.getImage("/sprites/character/idle/adventurer-idle-0"+frame/8 %4+".png");
		}
	}
}
