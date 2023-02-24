package objects;


import collision.SphereHitBox;
import javafx.scene.image.Image;



public class Npc implements IGameCharacter{

	private double x, y, HP, width, height, walkSpeed, runSpeed;
	private SphereHitBox hb;
	private Image sprite;
	private boolean jumpAbility; //is NPc-object allowed to jump?

	/**Variable of whether NPC is currently aggro;
	 * false is peaceful, and true is moving towards player and attacking
	 */
	private boolean aggro; 


	public Npc(double x, double y, EntityRecord entRec) {
		this.x = x;
		this.y = y;
		this.hb = new SphereHitBox(this, 150);
		this.HP = entRec.HP();
		this.width = entRec.width();
		this.height = entRec.height();
		this.walkSpeed = entRec.walkSpeed();
		this.runSpeed = entRec.runSpeed();
		this.sprite = entRec.sprite();
		this.jumpAbility = entRec.jumpAbility();
		

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
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		return this.y;
	}

	@Override
	public double getWidth() {
		return this.width;
	}

	@Override
	public double getHeight() {
		return this.height;
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

	@Override
	public void move() {
		
	}

	@Override
	public double getHP() {
		return this.HP;
	}

	@Override
	public boolean isAlive() {
		if(getHP()<= 0){
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void setHp(double hp) {
		this.HP = hp;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}


}
