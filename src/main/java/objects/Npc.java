package objects;

import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class Npc implements IGameObject{
	public Npc() {
		
	}
	
	@Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 300;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 111;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 150;
	}

	@Override
	public Image getSprite() {
		return ImageLoader.getImage("/sprites/character/idle/adventurer-idle-00.png");
	}
}
