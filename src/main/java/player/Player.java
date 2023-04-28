package player;


import collision.PolygonHitBox;
import collision.SphereHitBox;
import javafx.scene.image.Image;
import objects.GameActor;
import objects.IGameObject;

public class Player extends GameActor{

	private static double runSpeed = PlayerStats.runSpeed;
	private boolean moveRight;
	private boolean moveLeft;
	
	private boolean shift;
	
	private int jumpTime;
	private double jumpDir;
	private int air;
	private int invFrames;
	
	private PlayerMovementState movementState = PlayerMovementState.idle;
	public PlayerActionState actionState = null;
	private SphereHitBox hb; 

	private boolean attack;
	
	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		this.h = PlayerStats.height;
		this.w = PlayerStats.width;
		this.hp = PlayerStats.Hp;

		//bytt ut når polygon hitbox er ferdig
		//this.hb = new PolygonHitBox(this, *liste over koordinater*)
		this.hb = new SphereHitBox(this, this.h);
	}

	@Override
	public Image getSprite() {
		if (this.actionState != null) {
			return PlayerAnimation.getSprite(actionState, this.frameCount);
		}
		return PlayerAnimation.getSprite(movementState,this.frameCount);
	}
	
	@Override
	public void move() {
		
		if (this.invFrames > 0) {
			this.invFrames--;
		}
		
		if (this.gravity == null) {
			this.air--;
		}else {
			this.air = 2 * 30;
		}
		
		if(actionState == null) {
			actionState = PlayerActionState.getState(this);
		}else {
			if (actionState.isOver(this)) {
				actionState = PlayerActionState.getState(this);
			}
		}
		if (movementState.isOver(this)) {
			movementState = PlayerMovementState.getState(this);
		}
		//this.rotation = this.rotation - ((this.rotation%360)-this.deg)/4;
		
		switch(movementState) {
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
			if (this.gravity == null) this.jumpTime++;
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
	
	public PlayerMovementState getMovementState() {
		return this.movementState;
	}

	public void initAttack(boolean b) {
		this.attack = b;
	}

	public boolean isOverlapping(PolygonHitBox other) {
		return getHitBox().intersects(other);
	}

	public void givePowerUp(IGameObject obj) {
		this.runSpeed = 20;
	}
	
	public int getAirSupply() {
		return this.air;
	}
	@Override
	public boolean isAlive() {
		return this.hp > 0 && this.air > 0;
	}

	public void takeDamage() {
		if (this.invFrames == 0) {
			this.invFrames = 50;
			this.hp -= 10;
		}
				
	}
	public void setAirSupply(int air) {
		this.air = air;
	}
}
