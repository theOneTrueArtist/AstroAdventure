package objects;

import collision.SphereHitBox;
import javafx.scene.image.Image;

public abstract class AbstractObject implements IGameObject{
	protected double x;
	protected double y;
	protected double w;
	protected double h;
	protected double dx, dy;
	
	protected double deg;
	protected int direction = 1;
	
	protected SphereHitBox hb;
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getWidth() {
		return this.w;
	}
	
	public double getHeight() {
		return this.h;
	}
	
	public double getDeg() {
		return this.deg;
	}
	
	public int getDirection() {
		return this.direction;
	}

	public SphereHitBox getHitBox() {
		return this.hb;
	}

	@Override
	public abstract Image getSprite();


	@Override
	public abstract void move();
	
}
