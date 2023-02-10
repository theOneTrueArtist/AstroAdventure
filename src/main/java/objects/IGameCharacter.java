package objects;

public interface IGameCharacter extends IGameObject{
	public void move();
	public double getHP();
	public boolean isAlive();
	public void setHp(double hp);
	public void setX(double x);
	public void setY(double y);
}
