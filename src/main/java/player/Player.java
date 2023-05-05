package player;


import collision.SphereHitBox;
import javafx.scene.image.Image;
import objects.AbstractPowerUp;
import objects.GameActor;


/** Represents the player, contains all relevant information about the player and their state. */
public class Player extends GameActor{

	private double runSpeed = PlayerStats.runSpeed;
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
	public boolean activePowerCell;
	
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
	/**
	 * set character moves left value
	 * @param move
	 */
	public void moveLeft(boolean move) {
		this.moveLeft = move;
	}
	/**
	 * set character moves right value
	 * @param move
	 */
	public void moveRight(boolean move) {
		this.moveRight = move;
	}
	/**
	 * set character shift value
	 * @param move
	 */
	public void setShift(boolean shift) {
		this.shift = shift;
	}
	/**
	 * get if player is running if player is grounded and moving left exclusive or moving right
	 * @param move
	 */
	public boolean isRunning() {
		return this.grounded && (this.moveLeft ^ this.moveRight);
	}

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}
	/**
	 * a jumping force is applied to the player
	 * @param b
	 */
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

	/**
	 * check if player is jumping
	 * @return
	 */
	public boolean isjumping() {
		return jumpTime != 0;
	}
	/**
	 * check if player is crouching
	 * @return
	 */
	public boolean isCrouching() {
		return this.shift && this.grounded;
	}

	/**
	 * check if player is attacking
	 * @return
	 */
	public boolean isAttacking() {
		return this.attack;
	}

	/**
	 * check if player is sliding, true if player is shift and grounded and running, false otherwise
	 * @return
	 */
	public boolean isSliding() {
		return this.shift && this.grounded && this.isRunning();
	}

	/**
	 * gets players current movment state
	 * @return active PlayerMovementState
	 */
	public PlayerMovementState getMovementState() {
		return this.movementState;
	}

	/**
	 * start a attack
	 * @param b
	 */
	public void initAttack(boolean b) {
		this.attack = b;
	}


	/**
	 * apply the effects of powerup object to the players stats product wise
	 * @param obj
	 */
	public void givePowerUp(AbstractPowerUp obj) {
		this.activePowerCell = true;
		this.runSpeed *= obj.productSpeed();
		this.h *= obj.productHeight();
		this.w *= obj.productWidth();
		this.air *= obj.productAir();
		this.hp *= obj.productHealth();
	}

	/**
	 * gets players current air levels
	 * @return
	 */
	public int getAirSupply() {
		return this.air;
	}
	/**
	 * checks if player is alive, true if hp and air is greater then 0 false otherwise
	 */
	@Override
	public boolean isAlive() {
		return this.hp > 0 && this.air > 0;
	}

	/**
	 * players health is decreased by damage
	 */
	public void takeDamage() {
		if (this.invFrames == 0) {
			this.invFrames = 50;
			this.hp -= 10;
		}
				
	}
	/**
	 * set players air level
	 * @param air
	 */
	public void setAirSupply(int air) {
		this.air = air;
	}
}

