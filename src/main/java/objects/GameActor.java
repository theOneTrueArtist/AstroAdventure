package objects;

import gravity.SphereGravity;

public abstract class GameActor implements IGameObject{
	protected double x;
	protected double y;
	protected double w;
	protected double h;
	protected double hp;
	protected double dx, dy;
	
	protected double deg;
	protected double rotation;
	
	protected boolean grounded = false;
	protected SphereGravity gravity;
	
	
	public void moveHorizontal(double vel) {
		double r = this.deg*Math.PI/180;
		this.dx += Math.cos(r) * vel;
		this.dy += Math.sin(r) * vel;
	}
	
	public void moveVertical(double vel) {
		double r = (this.deg + 90)*Math.PI/180;
		this.dx += Math.cos(r) * vel;
		this.dy += Math.sin(r) * vel;
	}	
	
	public void moveInDir(double vel, double r) {
		double r1 = (r + 90)*Math.PI/180;
		this.dx += Math.cos(r1) * vel;
		this.dy += Math.sin(r1) * vel;		
	}
	
	/**
	* Moves game character
	*/
	public abstract void move();
	
	/**
	 * steps the character
	 */
	public void step() {
		this.dx = 0;
		this.dy = 0;
		move();
		this.x += this.dx;
		this.y += this.dy;
	}

	/**
	* @return x-coordinate of object
	*/
	public double getX() {
		return this.x;
	}
	/**
	* @return y-coordinate of object
	*/
	public double getY() {
		return this.y;
	}
	
	
	/**
	* @Return HP of Game Character
	*/
	public double getHP() {
		return this.hp;
	}

	/**
	 *@return boolean of whether character is alive or dead
	 */
	public boolean isAlive() {
		return this.hp < 0;
	}
	/**
	 * Sets HP
	 */
	public void setHp(double hp) {
		this.hp = hp;
	}
	/**
	 * Sets x-coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Sets y-coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}
	public double getDX() {
		return this.dx;
	}
	public double getDY() {
		return this.dy;
	}
	
	public double getWidth() {
		return this.w;
	}
	
	public double getHeight() {
		return this.h;
	}
	
	public double getDeg() {
		return this.deg;
	}
	
	public boolean isGrounded() {
		return this.grounded;
	}
	
	public void setGravity(SphereGravity gravity) {
		this.gravity = gravity;
	}
	
	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}

	public double getRot() {
		return this.rotation;
	}
	
	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
}
