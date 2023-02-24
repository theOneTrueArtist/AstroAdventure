package objects;

public interface IGameCharacter extends IGameObject{

	/**
	* Moves game character
	*/

	public void move();

	/**
	* @Return HP of Game Charcter
	*/
	public double getHP();

	/**
	 *@return boolean of whether character is alive or dead
	 */
	public boolean isAlive();
	/**
	 * Sets HP
	 */
	public void setHp(double hp);
	/**
	 * Sets x-coordinate
	 */
	public void setX(double x);
	/**
	 * Sets y-coordinate
	 */
	public void setY(double y);
}
