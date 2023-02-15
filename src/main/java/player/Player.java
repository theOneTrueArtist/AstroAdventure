package player;


import collision.SphereHitBox;
import gravity.SphereGravity;
import javafx.scene.image.Image;
import objects.IGameCharacter;

public class Player implements IGameCharacter{
	private double x, y, dx, dy;
	
	private double h = PlayerStats.height;
	private double w = PlayerStats.width;
	private double hp = PlayerStats.Hp;
	private double runSpeed = PlayerStats.runSpeed;
	
	private boolean moveRight = false;
	private boolean moveLeft = false;
	public int direction = 1;
	private boolean grounded = true;

	private PlayerState state = PlayerState.idle;
	private int frameCount = 0; 
	
	private SphereHitBox hb;
	private SphereGravity gravity;
	
	private double deg = 0;
	
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

	@Override
	public void move() {
		state = PlayerState.getState(this);
		frameCount++;
		this.dx = 0;
		this.dy = 0;
		if (this.moveLeft) {
			this.direction = -1;
			this.dx += -this.runSpeed;
		}
		if (this.moveRight) {
			this.direction = 1;
			this.dx += this.runSpeed;
		}
		
		if (this.gravity != null) {
			this.dx -= (this.getX() - this.gravity.getX())/100;
			this.dy -= (this.getY() - this.gravity.getY())/100;
		}
		this.x += this.dx;
		this.y += this.dy;
		
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
		return this.grounded && (this.moveLeft || this.moveRight);
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
}
