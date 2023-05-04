package victoryScene;

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
import scenes.IScene;
import scenes.StartScene;

public class VictoryScene implements IScene {

    private App app;
    private boolean start;
    int timer = 20;

    public VictoryScene(App app) {
        this.app = app;
        app.getScene().setOnKeyPressed( e -> keyPressed(e) );
    }

    public void keyPressed(KeyEvent evt) {
        KeyCode key = evt.getCode();  // keyboard code for the pressed key
        if (key == KeyCode.SPACE) {
            this.start = true;
        }
    }

    @Override
    public void step(int stepCount) {
        if(start) {
            this.timer--;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        context.drawImage(ImageLoader.getImage("/sprites/background_elements/Space_Background.png"),0,0);
        context.setFill(Color.WHITE);
        // Coins/Diamonds Collected
        context.setFont(new Font(100));
        context.fillText("Victory!", canvas.getWidth()/2-150,100);

        context.setFont(new Font(60));
        context.fillText("You got to the portal!", canvas.getWidth()/2-250,200);

        context.setFont(new Font(20));
        context.fillText("Press space to go back to the main menu!", canvas.getWidth()/2-160,400);
    }

    @Override
    public boolean isOver() {
        return this.start && timer == 0;
    }

    @Override
    public IScene transitionTo() {
        return new StartScene(this.app);
    }
}
