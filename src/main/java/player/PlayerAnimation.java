package player;

import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class PlayerAnimation {

	public static Image getSprite(PlayerMovementState state,int frame) {
		switch (state) {
			case jump:
				return ImageLoader.getImage("/sprites/character/jump/adventurer-crnr-jmp-0"+frame/8 %2+".png");
			case run:
				return ImageLoader.getImage("/sprites/character/run/adventurer-run-0"+frame/8 %6+".png");
			case fall:
				return ImageLoader.getImage("/sprites/character/fall/adventurer-fall-0"+frame/8 %2+".png"); 		
			case slide:
				if (frame < 48) return ImageLoader.getImage("/sprites/character/slide/adventurer-slide-0"+frame/8 % 2+".png");
				return ImageLoader.getImage("/sprites/character/slide/adventurer-stand-0"+frame/8%3 +".png");
			case crouch:
				return ImageLoader.getImage("/sprites/character/crouch/adventurer-crouch-0"+frame/8 %4+".png");			
			
			default:
				return ImageLoader.getImage("/sprites/character/idle/adventurer-idle-0"+frame/8 %4+".png");
		}
	}
	
	public static Image getSprite(PlayerActionState state,int frame) {
		switch (state) {
			case dead:
				return ImageLoader.getImage("/sprites/character/die/adventurer-die-0"+frame/8+".png"); 
			case attack1:
				return ImageLoader.getImage("/sprites/character/attack1/adventurer-attack1-0"+frame/6+".png");
			case attack2:
				return ImageLoader.getImage("/sprites/character/attack2/adventurer-attack2-0"+frame/6+".png");
			case attack3:
				return ImageLoader.getImage("/sprites/character/attack3/adventurer-attack3-0"+frame/8+".png");
			case air_attack1:
				return ImageLoader.getImage("/sprites/character/air-attack1/adventurer-air-attack1-0"+frame/6+".png");
			case air_attack2:
				return ImageLoader.getImage("/sprites/character/air-attack2/adventurer-air-attack2-0"+frame/6+".png");
			case air_attack3:
				return ImageLoader.getImage("/sprites/character/air-attack3/adventurer-air-attack3-loop-0"+frame/8%2+".png");	
			default:
				return ImageLoader.getImage("/sprites/character/idle/adventurer-idle-0"+frame/8+".png");
		}
	}
}
