package objects;

import collision.SphereHitBox;
import javafx.scene.image.Image;

public interface IGameObject {
	public double getX();
	public double getY();
	public double getWidth();
	public double getHeight();
	public Image getSprite();
	public SphereHitBox getHitBox();
	public void move();
}
