package scenes;

import game.Game;
import helpScene.HelpScene;
import inf112.skeleton.app.App;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


/**
 * Represents the startmenu, shows title, and leads to tutorial and game.
 */
public class StartScene implements IScene{
	private App app;
	private boolean cont;
	private boolean help;
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
		if (key == KeyCode.BACK_SPACE) {
			this.help = true;
		}
	}
	@Override
	public void draw(Canvas canvas) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		context.drawImage(ImageLoader.getImage("/sprites/background_elements/Space_Background.png"),0,0);
		context.setFill(Color.WHITE);
		// Coins/Diamonds Collected
		context.setFont(new Font(50));
		context.fillText("Astro Adventure", canvas.getWidth()/2-200,200);
		
		context.setFont(new Font(20));
		context.fillText("press space to start", canvas.getWidth()/2-110,400);
		context.setFont(new Font(20));
		context.fillText("press backspace for help", canvas.getWidth()/2-130,450);
		
		
	}

	@Override
	public boolean isOver() {
		return this.cont && timer == 0 || this.help;
	}

	@Override
	public IScene transitionTo() {
		if (this.help) {
			return new HelpScene(this.app);
		}
		return new Game(this.app);
	}

}
