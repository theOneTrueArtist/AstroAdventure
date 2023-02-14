package game;

import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
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
			context.setFill(Color.RED);
			context.fillOval(obj.getX()-obj.getWidth()/2-offsettX, obj.getY()-obj.getHeight()/2-offsettY, obj.getWidth(), obj.getHeight());
		}
	}
	
	
	public static void drawScreen(Canvas canvas,Player player,List<IGameObject> gameObjects) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		Image playerSprite = player.getSprite();
		double w = player.getWidth();
		double h = player.getHeight();
		context.drawImage(playerSprite,500-w/2*player.direction,300-h/2,w*player.direction, h);
		
		{
			context.setFill(Color.RED);
			context.fillOval(500-player.getHitBox().getR()/2,300-player.getHitBox().getR()/2, player.getHitBox().getR(), player.getHitBox().getR());
		}
		
		
		for(IGameObject obj : gameObjects) {
			cameraView(context, player, obj);
		}
		
	}
}
