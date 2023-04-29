package game;

import java.util.ArrayList;
import java.util.List;

import collision.CircleCollision;
import enemy.Enemy;
import inf112.skeleton.app.App;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import levels.Level;
import levels.LevelFactory;
import objects.IGameObject;
import objects.Sphere;
import player.Player;
import scenes.IScene;

public class Game implements IScene{
	
	private Player player = new Player(100,300);
	InputHandler inputHandler;
	Level level = LevelFactory.produce("level1.txt");
	App app;
	
	public Game(App app) {
		this.app = app;
		inputHandler = new InputHandler(player);
		app.getScene().setOnKeyPressed( e -> inputHandler.keyPressed(e) );
		app.getScene().setOnKeyReleased( e -> inputHandler.keyReleased(e) );
	}

	@Override
	public void step(int stepCount) {
		GameStep.step(player, level);
	}

	@Override
	public void draw(Canvas canvas) {
		GameGraphics.drawScreen(canvas,player,level);
		GameGraphics.drawHud(canvas,player);
	}
	
	@Override
	public boolean isOver() {
		return !player.isAlive() && player.getFrameCount() == 55;
	}

	@Override
	public IScene transitionTo() {
		return new Game(this.app);
	}
	
}
