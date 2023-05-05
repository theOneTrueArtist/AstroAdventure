package scenes;

import javafx.scene.canvas.Canvas;

public interface IScene {
	/**
	* a Step is a single frame of action in the game
	*/
	public void step(int stepCount);
	/**
	* draw is used to show the different objects on screen
	*/
	public void draw(Canvas canvas);
	/**
	 * checks if state is over
	 * @return boolean
	 */
	public boolean isOver();
	/**
	 * finds a new scene to tranistion to
	 * @return new IScene
	 */
	public IScene transitionTo();
	
}
