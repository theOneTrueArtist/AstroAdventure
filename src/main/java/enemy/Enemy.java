package enemy;


import collision.SphereHitBox;
import javafx.scene.image.Image;
import objects.GameActor;
import player.Player;

/**
 * Represents the Aliens!
 */
public class Enemy extends GameActor{

	/** The speed of the alien */
	private double runSpeed;

	/** The aliens hitbox */
	private SphereHitBox hb;
	
	/** The target the alien is chasing */
	private Player target; 

	/** The current state of the enemy */
	private EnemyState state = EnemyState.run;


	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		this.hp = 20;
		this.w = 60;
		this.h = 100;
		this.hb = new SphereHitBox(this, this.h);
		this.runSpeed = 6;
	}

	/**
	 * Sets the target for the enemy
	 * @param p The target you want it set to.
	 */
	public void setTarget(Player p){
		this.target = p;
	}

	@Override
	public Image getSprite() {

		this.frameCount ++;
		return EnemyAnimation.getSprite(state,this.frameCount);
	}

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}

	@Override
	public void move() {
		if (this.target != null) {
			double r = this.deg*Math.PI/180;
			//takes the dotproduct of vector to target + a dampener and movedir to find angle
			double dampener = 100;
			this.direction = (target.getX()-this.x - Math.cos(r)*dampener*-this.direction) * (Math.cos(r)) + ((target.getY()-this.y-Math.sin(r)*dampener*-this.direction)*(Math.sin(r))) > 0 ? 1 : -1;
		}
		moveHorizontal(this.runSpeed * this.direction);
	}

	/** Returns boolean of wheter enemy is jumping */
	public boolean isjumping() {
		return false;
	}

	/** Returns boolean of wheter enemy is running. */
	public boolean isRunning() {
		return true;
	}

}
