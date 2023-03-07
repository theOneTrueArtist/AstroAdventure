package objects;


import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class Npc extends GameActor{

	private double walkSpeed, runSpeed;
	private SphereHitBox hb;
	private Image sprite;
	private boolean jumpAbility; //is NPc-object allowed to jump? yes?

	/**Variable of whether NPC is currently aggro;
	 * false is peaceful, and true is moving towards player and attacking
	 */
	private boolean aggro; 


	public Npc(double x, double y, EntityRecord entRec) {
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
	public Npc(int x, int y) {
		this.x = x;
		this.y = y;
		this.hp = 20;
		this.w = 100;
		this.h = 200;
		this.hb = new SphereHitBox(this, this.h);
		this.walkSpeed = 2;
		this.runSpeed = 5;
		this.sprite = ImageLoader.getImage("/sprites/character/idle/adventurer-idle-00.png");
		this.jumpAbility = true;
	}

	public boolean getAggro(){
		return this.aggro;
	}

	public void setAggro(boolean a){
		this.aggro = a;
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
		return this.sprite;
	}

	@Override
	public SphereHitBox getHitBox() {
		return this.hb;
	}

	public void move() {
		moveHorizontal(runSpeed);
	}

}
