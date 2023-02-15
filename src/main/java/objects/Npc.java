package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class Npc implements IGameCharacter{
	private double x;
	private double y;
	private SphereHitBox hb;
	public Npc(double x, double y) {
		this.x = x;
		this.y = y;
		this.hb = new SphereHitBox(this, 150);
	}
	
	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
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

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHp(double hp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		
	}
}
