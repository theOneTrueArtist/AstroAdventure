package collision;

import objects.IGameObject;

public class SphereHitBox implements IHitBox{
	IGameObject target;
	double r;
	public SphereHitBox(IGameObject target, double r) {
		this.target = target;
		this.r = r;
	}
	
	public double getR() {
		return this.r;
	}
	
	public double getX() {
		return target.getX();
	}
	public double getY() {
		return target.getY();
	}

	@Override
	public boolean intersects(IHitBox target) {
		return false;
	}
}
