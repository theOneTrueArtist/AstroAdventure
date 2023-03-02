package player;


import collision.SphereHitBox;
import gravity.SphereGravity;
import javafx.scene.image.Image;
import objects.GameActor;

public class Player extends GameActor{

	private double runSpeed = PlayerStats.runSpeed;
	
	private boolean moveRight = false;
	private boolean moveLeft = false;
	public int direction = 1;
	private int jumpTime = 0;
	private double jumpDir = 0;
	
	private PlayerState state = PlayerState.idle;
	private int frameCount = 0;
	
	private SphereHitBox hb;
	
	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		this.h = PlayerStats.height;
		this.w = PlayerStats.width;
		this.hp = PlayerStats.Hp;
		this.hb = new SphereHitBox(this, this.h);

	}

	@Override
	public Image getSprite() {
		return PlayerAnimation.getSprite(state,frameCount);
	}
	
	@Override
	public void move() {
		state = PlayerState.getState(this);
		
		//this.rotation = this.rotation - ((this.rotation%360)-this.deg)/4;
		
		frameCount++;

		if (this.moveLeft ) {
			this.direction = -1;
			moveHorizontal(-this.runSpeed);
		}
		if (this.moveRight) {
			this.direction = 1;
			moveHorizontal( this.runSpeed);
		}
		
		if (this.gravity != null) {
			this.deg = 180 - Math.toDegrees(Math.atan2(this.x - this.gravity.getX(), this.y - this.gravity.getY()));
			if (jumpTime > 0) {
				this.jumpTime--;
				moveInDir(-10,jumpDir);
			}
			else if (!this.grounded)
				moveVertical(10);
		}
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

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}

	
	public void jumping(boolean b) {
		if (this.grounded) {
			this.jumpTime = 30;
			this.jumpDir = this.deg;
		}
	}

	public boolean isjumping() {
		return jumpTime != 0;
	}
}
