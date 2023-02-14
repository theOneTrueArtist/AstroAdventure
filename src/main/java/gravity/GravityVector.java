package gravity;

public class GravityVector {
	private double x;
	private double y;
	private double mag;
	
	public GravityVector(double x, double y, double mag) {
		this.x = x;
		this.y = y;
		this.mag = mag;
	}
	
	public double getX() {
		return this.x * this.mag;
	}
	public double getY() {
		return this.y * this.mag;
	}
	
	public boolean equals(Object obj) {
		 if (!(obj instanceof GravityVector))
			 return false;
		 
		 GravityVector v = (GravityVector) obj;
		 if (this.x != v.x || this.y != v.y || this.mag != v.mag) {
			 return false;
		 }
		 
		 return true;
	}
}
