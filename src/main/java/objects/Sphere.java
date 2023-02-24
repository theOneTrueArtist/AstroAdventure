package objects;

import collision.SphereHitBox;
import javafx.scene.image.Image;

public class Sphere implements IGameObject{
	double x, y, r;
	SphereHitBox hb;
	public Sphere(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.hb = new SphereHitBox(this,r);
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
		return this.r;
	}

	@Override
	public double getHeight() {
		return this.r;
	}

	@Override
	public Image getSprite() {
		return null;
	}

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}

	@Override
	public void move() {
		
	}
}
