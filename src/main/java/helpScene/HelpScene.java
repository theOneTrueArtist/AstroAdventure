package helpScene;

import gravity.SphereGravity;
import inf112.skeleton.app.App;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import objects.BackgroundElements;
import objects.IGameObject;
import player.Player;
import scenes.IScene;
import scenes.StartScene;

public class HelpScene implements IScene{
	private App app;
	private HelpInputHandler inputHandler;
	private Player player = new Player(100,300);
	private BackgroundElements tree;
	
	public boolean a;
	public boolean space;
	public boolean shift;
	public boolean right;
	public boolean left;
	public boolean back;
	public boolean i;
	
	public HelpScene(App app) {
		this.app = app;
		inputHandler = new HelpInputHandler(player,this);
		tree = new BackgroundElements(400, -36,200, 200,-5,"Tree1");
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
	private static void cameraView(GraphicsContext context, Player player, IGameObject obj) {
		double playerPosX = 500;
		double playerPosY = 300;
		double offsettX = player.getX() - playerPosX;
		double offsettY = player.getY() - playerPosY;
		context.save();
		context.translate(obj.getX()-offsettX, obj.getY()-offsettY);
		context.rotate(obj.getDeg());
		if (obj.getSprite() != null) {
			context.drawImage(obj.getSprite(),-obj.getWidth()/2,-obj.getHeight()/2,obj.getWidth(), obj.getHeight());
		}else {
			context.fillOval(-obj.getWidth()/2, -obj.getHeight()/2, obj.getWidth(), obj.getHeight());
		}
		context.restore();
	}
	
	@Override
	public void draw(Canvas canvas) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		context.save();

		// Space background
		context.drawImage(ImageLoader.getImage("/sprites/background_elements/Space_Background.png"),0,0);

		double offsettY = player.getY() - 300;
		context.setFill(new Color(0,0,1,0.3));
		context.fillRect(0, 10-offsettY-250, canvas.getWidth(), 500);
		context.setFill(Color.WHITE);
		context.fillRect(0, 10-offsettY+50, canvas.getWidth(), 100);
		
		cameraView(context, player, tree);
		
		Image playerSprite = player.getSprite();
		double w = player.getWidth()*player.getDirection();
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
		context.setFill(Color.RED);
		context.setFont(new Font(30));
		context.fillText("press Backspace to go back", canvas.getWidth()/2 - 200, canvas.getHeight() - 20);
		
		context.fillText(i ? "press i for less info" : "press i for more info", canvas.getWidth()/2 - 150, canvas.getHeight() - 60);
		
		if (this.i) {
			context.setFill(Color.rgb(255, 255, 255, 0.95));
			context.fillRect(200, 100, 600, 400);
			context.setFill(Color.BLACK);
			context.fillText("To Remember:", 260, 150);
			context.fillText("* Collect coins and find the power-up", 220, 200);
			context.fillText("* Dodge the enemy", 220, 250);
			context.fillText("* Jump from planet to planet", 220, 300);
			context.fillText("* Air-supply run out in space", 220, 350);
			context.fillText("*  Get power-up to make portal appair", 220, 400);
		}
	}

	@Override
	public boolean isOver() {
		return this.back;
	}

	@Override
	public IScene transitionTo() {
		return new StartScene(this.app);
	}
	
}
