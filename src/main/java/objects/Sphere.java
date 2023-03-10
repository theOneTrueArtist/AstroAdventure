package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class Sphere implements IGameObject{
	double x, y, r;
	int planet_type;
	SphereHitBox hb;
	public Sphere(double x, double y, double r, int planet_type) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.hb = new SphereHitBox(this,r);
		this.planet_type = planet_type;
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
		return ImageLoader.getImage("/sprites/planets/planet" + this.planet_type + ".png");
	}

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}

	@Override
	public void move() {
		
	}

	@Override
	public double getDeg() {
		return 0;
	}
}
