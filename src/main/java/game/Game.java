package game;

import inf112.skeleton.app.App;
import javafx.scene.canvas.Canvas;
import levels.Level;
import levels.LevelFactory;
import player.Player;
import scenes.IScene;
import sound.SoundTrack;
import victoryScene.VictoryScene;


/**
 * This class ties represents the game itself.
 */
public class Game implements IScene{
	private SoundTrack music;
	private Player player = new Player(100,300);
	private InputHandler inputHandler;
	private Level level = LevelFactory.produce("level1.txt");
	private App app;
	public int coinsCollected;
	public boolean victory = false;
	
	public Game(App app) {
		music = new SoundTrack();
		music.play();
		this.app = app;
		this.inputHandler = new InputHandler(player, music);
		app.getScene().setOnKeyPressed( e -> this.inputHandler.keyPressed(e) );
		app.getScene().setOnKeyReleased( e -> this.inputHandler.keyReleased(e) );
	}

	@Override
	public void step(int stepCount) {
		GameStep.step(this,player, level);
	}

	@Override
	public void draw(Canvas canvas) {
		GameGraphics.drawScreen(canvas,player,level);
		GameGraphics.drawHud(canvas,player, this);
	}
	
	@Override
	public boolean isOver() {
		return !player.isAlive() && player.getFrameCount() >= 55 || victory;
	}

	@Override
	public IScene transitionTo() {
		music.stop();
		if(victory) return new VictoryScene(this.app);
		return new Game(this.app);

	}
	
}
