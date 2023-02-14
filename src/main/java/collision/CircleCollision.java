package collision;

public class CircleCollision {
	public static boolean collides(SphereHitBox box1, SphereHitBox box2) {
		double sumr = box1.getR()/2 + box2.getR()/2;
		double dist = Math.sqrt(Math.pow(box1.getX() - box2.getX(),2)+Math.pow(box1.getY() - box2.getY(),2));
		return dist < sumr;
	}
 }
