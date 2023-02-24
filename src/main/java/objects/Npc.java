package objects;


import collision.SphereHitBox;
import javafx.scene.image.Image;



public class Npc implements IGameCharacter{

	private double x;
	private double y;
	private SphereHitBox hb;
	private double HP;
	private double width;
	private double height;
	private Image sprite;
	/**
	 * variable of whether NPC is currently aggro;
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
		this.sprite = entRec.sprite();

	}

	public boolean getAggro(){
		return this.aggro;
	}

	public void setAggro(boolean a){
		this.aggro = a;
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
