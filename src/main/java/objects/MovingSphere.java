package objects;

import java.util.ArrayList;


public class MovingSphere extends Sphere{
	private ArrayList<Point> points;
	private Point target;
	private int i = 0;
	private double dx;
	private double dy;
	
	public MovingSphere(double x, double y, double r, ArrayList<Point> points) {
		super(x, y, r, 2);
		this.points = points;
		target = points.get(0);
	}
	@Override
	public void move() {
		
		this.dx = this.x - this.points.get(i).getX();
		this.dy = this.y - this.points.get(i).getY();
		if (dx != 0) {
			this.dx = (this.dx/Math.sqrt(Math.pow(this.dx, 2)));
		}
		if (dy != 0) {
			this.dy =  (this.dy/Math.sqrt(Math.pow(this.dy, 2)));
		}
		
		
		if (this.x != this.points.get(i).getX())
			this.x += -this.dx;
		if (this.y != this.points.get(i).getY())
			this.y += -this.dy;
		
		if (this.x == this.points.get(i).getX() && this.y == this.points.get(i).getY()) {
			i = (i+1) % this.points.size();
		}
		
	}

}
