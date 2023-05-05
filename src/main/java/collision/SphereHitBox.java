package collision;

import objects.IGameObject;

public class SphereHitBox implements IHitBox{
	IGameObject target;
	double r;


	public SphereHitBox(IGameObject target, double r) {
		this.target = target;
		this.r = r;
	}
	/**
	 * get radius of object
	 * @return radius
	 */
	public double getR() {
		return this.r;
	}

	@Override
	public double getX() {
		return target.getX();
	}
	@Override
	public double getY() {
		return target.getY();
	}
}
