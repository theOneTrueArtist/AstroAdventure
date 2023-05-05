package collision;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import objects.IGameObject;

public class SphereHitBox implements IHitBox{
	IGameObject target;
	double r;
	Shape hitbox;


	public SphereHitBox(IGameObject target, double r) {
		this.target = target;
		this.r = r;

		this.hitbox = new Circle(r);
		//

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

	@Override
	public boolean intersects(IHitBox target) {
		Shape newBox = target.getShape();
        Shape interShape = Shape.intersect(this.hitbox, newBox);      
        return 0 < interShape.getBoundsInLocal().getWidth();
	}

	@Override
	public Shape getShape() {
		return this.hitbox;
	}
}
