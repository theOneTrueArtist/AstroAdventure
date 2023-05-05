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
	
	private IScene gameScene;


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
				// System.out.println("Elapsed: " + (now -
				// lastUpdateTime)/(double)millisPerStep);
				if (lastUpdateTime > 0) {
					timeBudget = Math.min(timeBudget + (now - lastUpdateTime), 10 * nanosPerStep);
				}
				lastUpdateTime = now;

				while (timeBudget >= nanosPerStep) {
					// System.out.println("Budget: " + timeBudget);
					timeBudget = timeBudget - nanosPerStep;
					step();
				}
				draw();
			}

		};
		root.getChildren().add(canvas);

		// canvas.setEffect(new BoxBlur());
		timer.start();
//		stage.setFullScreen(true);
		stage.show();


	}

	private void setup() {
		gameScene = new StartScene(this);
	}
	
	private int stepCount = 0;

	protected void step() {
		if (gameScene.isOver()) {
			gameScene = gameScene.transitionTo();
		}
		
		gameScene.step(stepCount);
		stepCount++;
	}

	protected void draw() {
		gameScene.draw(canvas);	
	}
	public Scene getScene() {
		return scene;
	}
}
