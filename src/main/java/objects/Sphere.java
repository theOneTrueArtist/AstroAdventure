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
		// TODO Auto-generated method stub
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
		return this.r;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return this.r;
	}

	@Override
	public Image getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SphereHitBox getHitBox() {
		// TODO Auto-generated method stub
		return this.hb;
	}
}
