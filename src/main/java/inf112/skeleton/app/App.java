package inf112.skeleton.app;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import scenes.IScene;
import scenes.StartScene;

public class App extends Application {
	private AnimationTimer timer;
	private Canvas canvas;
	private long nanosPerStep = 1000_000_000L / 60L;
	private long timeBudget = nanosPerStep;
	private long lastUpdateTime = 0L;
	private Scene scene;
	private int stepCount = 0;
	
	private IScene gameScene;

	/**
	 * Starts the game.
	 * @param args
	 */
	public static void startIt(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		double width = 1000;
		double height = 600;
		Group root = new Group();
		scene = new Scene(root, width, height, Color.BLACK);
		stage.setScene(scene);

		canvas = new Canvas(width, height);
		canvas.widthProperty().bind(scene.widthProperty());
		canvas.heightProperty().bind(scene.heightProperty());

		setup();

		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				if (lastUpdateTime > 0) {
					timeBudget = Math.min(timeBudget + (now - lastUpdateTime), 10 * nanosPerStep);
				}
				lastUpdateTime = now;

				while (timeBudget >= nanosPerStep) {
					timeBudget = timeBudget - nanosPerStep;
					step();
				}
				draw();
			}

		};
		root.getChildren().add(canvas);
		timer.start();
		stage.show();
	}

	/**
	 * Sets the gamescene to a new startmenu.
	 */
	private void setup() {
		gameScene = new StartScene(this);
	}

	/**
	 * Step is the internal timer off the game
	 */
	protected void step() {
		if (gameScene.isOver()) {
			gameScene = gameScene.transitionTo();
		}
		
		gameScene.step(stepCount);
		stepCount++;
	}

	/**
	 * Draws on the screen
	 */
	protected void draw() {
		gameScene.draw(canvas);	
	}

	/**
	 * Gets scene.
	 */
	public Scene getScene() {
		return scene;
	}
}
