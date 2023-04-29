package enemy;


import collision.SphereHitBox;
import javafx.scene.image.Image;
import objects.EntityRecord;
import objects.GameActor;
import player.Player;


public class Enemy extends GameActor{

	private double walkSpeed, runSpeed;
	private SphereHitBox hb;
	private Image sprite;
	private boolean jumpAbility; //is NPc-object allowed to jump? yes?
	
	private Player target; 
	private EnemyState state = EnemyState.run;


	public Enemy(double x, double y, EntityRecord entRec) {
		this.x = x;
		this.y = y;
		this.hp = entRec.HP();
		this.w = entRec.width();
		this.hb = new SphereHitBox(this, 150); // this.h -> 150 må være equal t h per nå for å få hitboxen til å stemme
		this.h = entRec.height();
		this.walkSpeed = entRec.walkSpeed();
		this.runSpeed = entRec.runSpeed();
		this.sprite = entRec.sprite();
		this.jumpAbility = entRec.jumpAbility();
	}

	//testing ikkje viktig
	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		this.hp = 20;
		this.w = 60;
		this.h = 100;
		this.hb = new SphereHitBox(this, this.h);
		this.walkSpeed = 4;
		this.runSpeed = 6;
		this.sprite = EnemyAnimation.getSprite(state,this.frameCount);
		//this.sprite = ImageLoader.getImage("/sprites/other_assets/Alien/Alien_idle_single.png");
		this.jumpAbility = true;
	}

	public boolean getAggro(){
		return this.target != null;
	}

	public void setTarget(Player p){
		this.target = p;
	}

	public Player getTarget() {
		return this.target;
	}
	
	public boolean getJumpAbility(){
		return this.jumpAbility;
	}

	public double getWalkSpeed(){
		return this.walkSpeed;
	}

	public double getRunSpeed(){
		return this.runSpeed;
	}
	
	@Override
	public Image getSprite() {
		//old method:
		//return ImageLoader.getImage("/sprites/character/idle/adventurer-idle-00.png");
		this.frameCount ++;
		return EnemyAnimation.getSprite(state,this.frameCount);
	}

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}

	public void move() {
		if (this.target != null) {
			double r = this.deg*Math.PI/180;
			//takes the dotproduct of vector to target + a dampener and movedir to find angle
			double dampener = 100;
			this.direction = (target.getX()-this.x - Math.cos(r)*dampener*-this.direction) * (Math.cos(r)) + ((target.getY()-this.y-Math.sin(r)*dampener*-this.direction)*(Math.sin(r))) > 0 ? 1 : -1;
		}
		moveHorizontal(this.runSpeed * this.direction);
	}

	public boolean isjumping() {
		return false;
	}

	public boolean isRunning() {
		return true;
	}

}
