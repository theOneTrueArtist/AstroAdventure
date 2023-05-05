package collision;

public class CircleCollision {

	/***
	 * checks if two circles overlap
	 * @param box1
	 * @param box2
	 * @return true if overlap false otherwise
	 */
	public static boolean collides(SphereHitBox box1, SphereHitBox box2) {
		double sumr = box1.getR()/2 + box2.getR()/2;
		double dist = Math.sqrt(Math.pow(box1.getX() - box2.getX(),2)+Math.pow(box1.getY() - box2.getY(),2));
		return dist < sumr;
	}
}
