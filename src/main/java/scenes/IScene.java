package scenes;

import javafx.scene.canvas.Canvas;

public interface IScene {
	public void step(int stepCount);
	public void draw(Canvas canvas);
}
