package helpScene;

import gravity.SphereGravity;
import inf112.skeleton.app.App;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import player.Player;
import scenes.IScene;

public class HelpScene implements IScene{
	private App app;
	private HelpInputHandler inputHandler;
	private Player player = new Player(100,300);
	
	boolean a;
	boolean space;
	boolean shift;
	boolean right;
	boolean left;
	
	
	public HelpScene(App app) {
		this.app = app;
		inputHandler = new HelpInputHandler(player,this);
		app.getScene().setOnKeyPressed( e -> inputHandler.keyPressed(e) );
		app.getScene().setOnKeyReleased( e -> inputHandler.keyReleased(e) );
	}
	
	@Override
	public void step(int stepCount) {
		//if (player.getMovementState() != PlayerMovementState.jump)
		player.setGravity(new SphereGravity(player.getX(), player.getY()+20, 50));
		
		player.step();
		if (player.getY() > 10) {
			player.setGrounded(true);
			player.moveTo(player.getX(), 10);
		}		
		player.setAirSupply(20);
	}

	@Override
	public void draw(Canvas canvas) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		context.save();
		double offsettY = player.getY() - 300;
		context.setFill(Color.BLUE);
		context.fillRect(0, 10-offsettY-250, canvas.getWidth(), 500);
		context.setFill(Color.WHITE);
		context.fillRect(0, 10-offsettY+50, canvas.getWidth(), 100);
		
		
		Image playerSprite = player.getSprite();
		double w = player.getWidth()*player.direction;
		double h = player.getHeight();
		{//player
			context.translate(500, 300);
			context.rotate(player.getDeg());
			context.drawImage(playerSprite,-w/2,-h/2,w, h);
			context.restore();
		}
		
		
		context.setFill(Color.rgb(255,255,255,0.5));
		if (this.a)
			context.setFill(Color.WHITE);
		context.fillRoundRect(20,20,50,50,5,5);
		
		context.setFill(Color.rgb(0, 0, 0, 0.5));
		if (this.a)
			context.setFill(Color.BLACK);
		context.setFont(new Font(30));
		context.fillText("A", 35,60);
			
		context.setFill(Color.rgb(255,255,255,0.5));
		if (this.shift)
			context.setFill(Color.WHITE);
		context.fillRoundRect(80,20,70,50,5,5);
		context.setFill(Color.rgb(0, 0, 0, 0.5));
	
		if (this.shift)
			context.setFill(Color.BLACK);
		context.setFont(new Font(30));
		context.fillText("Shift", 83,60);
		
		context.setFill(Color.rgb(255,255,255,0.5));
		if (this.space)
			context.setFill(Color.WHITE);
		context.fillRoundRect(160,20,130,50,5,5);
		context.setFill(Color.rgb(0, 0, 0, 0.5));
		if (this.space)
			context.setFill(Color.BLACK);
		context.setFont(new Font(30));
		context.fillText("Space", 183,60);
		
		context.setFill(Color.rgb(255,255,255,0.5));
		if (this.left)
			context.setFill(Color.WHITE);
		context.fillRoundRect(300,20,50,50,5,5);
		context.setFill(Color.rgb(0, 0, 0, 0.5));
		if (this.left)
			context.setFill(Color.BLACK);
		context.setFont(new Font(30));
		context.fillText("<", 310,60);
		
		context.setFill(Color.rgb(255,255,255,0.5));
		if (this.right)
			context.setFill(Color.WHITE);
		context.fillRoundRect(360,20,50,50,5,5);
		context.setFill(Color.rgb(0, 0, 0, 0.5));
		if (this.right)
			context.setFill(Color.BLACK);
		context.setFont(new Font(30));
		context.fillText(">", 380,60);
		
		
		context.setFill(Color.BLACK);
		context.setFont(new Font(11));
		if (player.isGrounded())
			context.fillText("Attack", 30,35);
		else
			context.fillText("Air-Attack", 20,35);
		if (player.isRunning())
			context.fillText("Slide", 95,35);
		else
			context.fillText("Crouch", 95,35);
		context.fillText("Jump", 210,35);
		if (player.isCrouching())
			context.fillText("Slide", 312,35);
		else
			context.fillText("Run-Left", 305,35);
		if (player.isCrouching())
			context.fillText("Slide", 375,35);
		else
			context.fillText("Run-Right", 360,35);
		
		
	}

	@Override
	public boolean isOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IScene transitionTo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
