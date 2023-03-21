package player;


import collision.SphereHitBox;
import javafx.scene.image.Image;
import objects.GameActor;

public class Player extends GameActor{

	private double runSpeed = PlayerStats.runSpeed;
	
	private boolean moveRight;
	private boolean moveLeft;
	
	private boolean shift;
	
	public int direction = 1;
	
	private int jumpTime = 0;
	private double jumpDir = 0;
	
	private PlayerState state = PlayerState.idle;
	
	private SphereHitBox hb;

	private boolean attack;
	
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
		return PlayerAnimation.getSprite(state,this.frameCount);
	}
	
	@Override
	public void move() {
		if (state.isOver(this)) {
			state = PlayerState.getState(this);
		}
		
		//this.rotation = this.rotation - ((this.rotation%360)-this.deg)/4;
		
		switch(state) {
		case run:
			this.frameCount++;
			if (this.moveLeft ) {
				this.direction = -1;
				moveHorizontal(-this.runSpeed);
			}
			if (this.moveRight) {
				this.direction = 1;
				moveHorizontal( this.runSpeed);
			}
			break;
		case jump:
			this.frameCount++;
			this.jumpTime--;
			
			moveInDir(-40*jumpTime/40,jumpDir);
			if (this.gravity == null) this.jumpTime++; //todo fin bedre måte
			if (this.moveLeft) {
				moveHorizontal(-this.runSpeed/2);
			}
			if (this.moveRight) {
				moveHorizontal( this.runSpeed/2);
			}
			if (this.grounded) this.jumpTime = 0;
			break;
		case fall:
			this.frameCount++;
			if (this.moveLeft ) {
				moveHorizontal(-this.runSpeed/2);
			}
			if (this.moveRight) {
				moveHorizontal( this.runSpeed/2);
			}
			break;
		case dead:
			if (this.frameCount < 55) this.frameCount++; 
			break;
		case slide:
			this.frameCount++;
			if (this.frameCount < 48) this.moveHorizontal(this.direction*12);
			break;
		default:
			this.frameCount++;
			break;
		}
	}
	
	public void moveLeft(boolean move) {
		this.moveLeft = move;
	}
	public void moveRight(boolean move) {
		this.moveRight = move;
	}
	public void setShift(boolean shift) {
		this.shift = shift;
	}
	
	public boolean isRunning() {
		return this.grounded && (this.moveLeft ^ this.moveRight);
	}

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}
	
	public void jumping(boolean b) {
		if (!b) {
			this.jumpTime = 0;
			return;
		}
		if (this.grounded) {
			this.jumpTime = 35;
			this.jumpDir = this.deg;
			if (this.moveLeft)
				this.jumpDir -= 45;
			if (this.moveRight)
				this.jumpDir += 45;
		}
	}

	public boolean isjumping() {
		return jumpTime != 0;
	}
	
	public boolean isCrouching() {
		return this.shift && this.grounded;
	}
	
	public boolean isAttacking() {
		return this.attack;
	}
	
	public boolean isSliding() {
		return this.shift && this.grounded && this.isRunning();
	}
	
	public PlayerState getState() {
		return this.state;
	}

	public void initAttack(boolean b) {
		this.attack = b;
		
	}
}
