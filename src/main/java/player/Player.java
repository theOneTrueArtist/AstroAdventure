package player;


import collision.SphereHitBox;
import gravity.SphereGravity;
import javafx.scene.image.Image;
import objects.IGameCharacter;

public class Player implements IGameCharacter{
	private double x, y;
	public double vx,vy, hx,hy;
	
	private double h = PlayerStats.height;
	private double w = PlayerStats.width;
	private double hp = PlayerStats.Hp;
	private double runSpeed = PlayerStats.runSpeed;
	
	private boolean moveRight = false;
	private boolean moveLeft = false;
	public int direction = 1;
	private boolean grounded = false;
	private int jumpTime = 0;
	private double jumpDir = 0;
	private double rotation = 0;
	
	private PlayerState state = PlayerState.idle;
	private int frameCount = 0; 
	
	private SphereHitBox hb;
	private SphereGravity gravity;
	
	public double deg = 0;
	
	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		this.hb = new SphereHitBox(this, this.h);
	}
	
	@Override
	public double getX() {
		return this.x;
	}
	@Override
	public double getY() {
		return this.y;
	}

	@Override
	public double getWidth() {
		return this.w;
	}
	@Override
	public double getHeight() {
		return this.h;
	}

	@Override
	public Image getSprite() {
		return PlayerAnimation.getSprite(state,frameCount);
	}

	public static void moveHorizontal(Player character, double vel) {
		double r = character.deg*Math.PI/180;
		character.hx += Math.cos(r) * vel;
		character.hy += Math.sin(r) * vel;
	}
	
	public static void moveVertical(Player character, double vel) {
		double r = (character.deg + 90)*Math.PI/180;
		character.vx += Math.cos(r) * vel;
		character.vy += Math.sin(r) * vel;
	}	
	
	public static void moveInDir(Player character, double vel, double r) {
		double r1 = (r + 90)*Math.PI/180;
		character.vx += Math.cos(r1) * vel;
		character.vy += Math.sin(r1) * vel;		
	}
	
	@Override
	public void move() {
		state = PlayerState.getState(this);
		
		//this.rotation = this.rotation - ((this.rotation%360)-this.deg)/4;
		
		frameCount++;
		this.hx = 0;
		this.hy = 0;
		this.vx = 0;
		this.vy = 0;
		if (this.moveLeft) {
			this.direction = -1;
			moveHorizontal(this, -this.runSpeed);
		}
		if (this.moveRight) {
			this.direction = 1;
			moveHorizontal(this, this.runSpeed);
		}
		
		
		if (this.gravity != null) {
			this.deg = 180 - Math.toDegrees(Math.atan2(this.x - this.gravity.getX(), this.y - this.gravity.getY()));
			if (jumpTime > 0) {
				this.jumpTime--;
				moveInDir(this,-10,jumpDir);
			}
			else if (!this.grounded)
				moveVertical(this, 10);
		}
		this.x += this.getDX();
		this.y += this.getDY();
		
	}

	@Override
	public double getHP() {
		return this.hp;
	}
	@Override
	public boolean isAlive() {
		return this.hp > 0;
	}

	@Override
	public void setHp(double hp) {
		this.hp = hp;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}
	@Override
	public void setY(double y) {
		this.y = y;		
	}
	
	public void moveLeft(boolean move) {
		this.moveLeft = move;
	}
	public void moveRight(boolean move) {
		this.moveRight = move;
	}
	
	public boolean isRunning() {
		return (this.moveLeft || this.moveRight);// && this.grounded ;
	}
	
	public boolean isGrounded() {
		return this.grounded;
	}

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}

	public void setGravity(SphereGravity gravity) {
		this.gravity = gravity;
	}
	public double getDX() {
		return this.hx + this.vx;
	}
	
	public double getDY() {
		return this.hy + this.vy;
	}
	public double getDeg() {
		return this.deg;
	}
	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}

	public void jumping(boolean b) {
		if (this.grounded) {
			this.jumpTime = 30;
			this.jumpDir = this.deg;
		}
	}

	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getRot() {
		return this.rotation;
	}

	public boolean isjumping() {
		return jumpTime != 0;
	}
}
