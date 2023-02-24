package objects;

import collision.SphereHitBox;
import javafx.scene.image.Image;

public interface IGameObject {
	
	/**
	* @return x-coordinate of object
	*/
	public double getX();
	/**
	* @return y-coordinate of object
	*/
	public double getY();
	/**
	* @return width of object (in pixels)
	*/
	public double getWidth();
	/**
	* @Return height of object (in pixels)
	*/
	public double getHeight();
	/**
	* @return sprite(image) of object
	*/
	public Image getSprite();
	/**
	* @return SphereHitbox-object belonging to GameObject
	*/
	public SphereHitBox getHitBox();
	/**
	* moves game object
	*/
	public void move();
}
