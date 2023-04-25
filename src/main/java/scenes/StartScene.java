package scenes;

import game.Game;
import game.GameStep;
import inf112.skeleton.app.App;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StartScene implements IScene{
	private App app;
	private boolean cont = false;
	int timer = 20;
	
	public StartScene(App app) {
		this.app = app;
		app.getScene().setOnKeyPressed( e -> keyPressed(e) );
		
	}
	
	@Override
	public void step(int stepCount) {
		if (cont) {
			this.timer--;
		}
	}

	public void keyPressed(KeyEvent evt) {
		KeyCode key = evt.getCode();  // keyboard code for the pressed key			
		if (key == KeyCode.SPACE) {
			this.cont = true;
		}
	}
	@Override
	public void draw(Canvas canvas) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		context.setFill(Color.WHITE);
		// Coins/Diamonds Collected
		context.setFont(new Font(50));
		context.fillText("Astro Adventure", canvas.getWidth()/2-200,200);
		
		context.setFont(new Font(20));
		context.fillText("press space to start", canvas.getWidth()/2-100,400);

	}

	@Override
	public boolean isOver() {
		return this.cont && timer == 0;
	}

	@Override
	public IScene transitionTo() {
		
		return new Game(this.app);
	}

}
