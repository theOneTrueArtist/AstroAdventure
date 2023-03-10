package gravity;

import collision.SphereHitBox;
import javafx.scene.image.Image;
import objects.IGameObject;

public class GravityField implements IGameObject{
	private double x,y,w,h,deg,mag;
	private GravityVector vector;
	public GravityField(double x,double y,double w, double h,double deg,double mag) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.deg = deg;
		this.mag = mag;
		this.vector = new GravityVector(Math.cos(this.deg), Math.sin(this.deg), this.mag);
	}
	
	public GravityVector getGravityVector() {
		return this.vector;
	}
	
	@Override
	public double getX() {
		return this.x;
	}
	@Override
	public double getY() {
		return this.y;
	}
	@Override
	public double getWidth() {
		return this.w;
	}
	@Override
	public double getHeight() {
		return h;
	}
	@Override
	public Image getSprite() {
		return null;
	}

	@Override
	public SphereHitBox getHitBox() {
		return null;
	}

	@Override
	public void move() {
	}

	@Override
	public double getDeg() {
		return 0;
	}
}
