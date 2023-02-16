package game;

import java.util.List;

import gravity.SphereGravity;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import levels.Level;
import objects.IGameCharacter;
import objects.IGameObject;
import player.Player;

public class GameGraphics {
	private static void cameraView(GraphicsContext context, Player player, IGameObject obj) {
		double playerPosX = 500;
		double playerPosY = 300;
		double offsettX = player.getX() - playerPosX;
		double offsettY = player.getY() - playerPosY;
		if (obj.getSprite() != null) {
			context.drawImage(obj.getSprite(),obj.getX()-obj.getWidth()/2-offsettX,obj.getY()-obj.getHeight()/2-offsettY,obj.getWidth(), obj.getHeight());
		}else {
			context.fillOval(obj.getX()-obj.getWidth()/2-offsettX, obj.getY()-obj.getHeight()/2-offsettY, obj.getWidth(), obj.getHeight());
		}
	}
	
	public static void drawScreen(Canvas canvas,Player player, Level level) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		Image playerSprite = player.getSprite();
		double w = player.getWidth()*player.direction;
		double h = player.getHeight();
		
		context.setFill(Color.BLUE);
		for (SphereGravity gravity : level.getGravities()) {
			cameraView(context, player, gravity);
		}
		
		{/*
			context.setFill(Color.RED);
			context.fillOval(500-player.getHitBox().getR()/2,300-player.getHitBox().getR()/2, player.getHitBox().getR(), player.getHitBox().getR());
		*/}
		
		
		{//player
			context.save();
			context.translate(500, 300);
			context.rotate(player.getDeg());
			context.drawImage(playerSprite,-w/2,-h/2,w, h);
			context.restore();
			//context.drawImage(playerSprite,500-w/2*player.direction,300-h/2,w*player.direction, h);
		}
		
		
		for(IGameObject obj : level.getObjects()) {
			context.setFill(Color.WHITE);
			cameraView(context, player, obj);
		}
		for (IGameCharacter c : level.getEnemies()) {
			cameraView(context, player, c);
		}
		
		
		
	}
}
