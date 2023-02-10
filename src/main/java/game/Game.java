package game;

import java.util.ArrayList;
import java.util.List;

import inf112.skeleton.app.App;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import objects.IGameObject;
import objects.Npc;
import player.Player;
import scenes.IScene;

public class Game implements IScene{
	private Player player = new Player(50,300);
	InputHandler inputHandler;
	List<IGameObject> gameObjects = new ArrayList<IGameObject>();
	
	
	public Game(App app) {
		inputHandler = new InputHandler(player);
		app.getScene().setOnKeyPressed( e -> inputHandler.keyPressed(e) );
		app.getScene().setOnKeyReleased( e -> inputHandler.keyReleased(e) );
		
		gameObjects.add(new Npc());
	}

	@Override
	public void step(int stepCount) {
		player.move();
	}

	@Override
	public void draw(Canvas canvas) {
		GameGraphics.drawScreen(canvas,player,gameObjects);
		
	}
}
