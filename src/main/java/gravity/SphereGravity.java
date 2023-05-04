package gravity;

import collision.SphereHitBox;
import javafx.scene.image.Image;
import objects.IGameObject;

public class SphereGravity implements IGameObject{
	double x, y, r;
	SphereHitBox hb;
	public IGameObject obj;
	public SphereGravity (double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.hb = new SphereHitBox(this,r);
	}
	public SphereGravity(IGameObject obj, double r) {
		this.obj = obj;
		this.r = r;
		this.hb = new SphereHitBox(this, r);
	}

	@Override
	public double getX() {
		if (this.obj != null) {
			return obj.getX();
		}
		return this.x;
	}

	@Override
	public double getY() {
		if (this.obj != null) {
			return obj.getY();
		}
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
	public double getWeight() {
		if (this.obj == null) {
			return this.r/2;
		}
		return this.obj.getWidth();
	}
	@Override
	public double getDeg() {
		return 0;
	}
	@Override
	public int getDirection() {
		return 1;
	}
}
