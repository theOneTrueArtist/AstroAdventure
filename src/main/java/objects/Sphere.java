package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class Sphere extends AbstractObject{
	
	int planet_type;
	public Sphere(double x, double y, double r, int planet_type) {
		this.x = x;
		this.y = y;
		this.h = r;
		this.w = r;
		this.hb = new SphereHitBox(this,r);
		this.planet_type = planet_type;
	}

	@Override
	public Image getSprite() {
		return ImageLoader.getImage("/sprites/planets/planet" + this.planet_type + ".png");
	}

	@Override
	public void move() {
		
	}
}
