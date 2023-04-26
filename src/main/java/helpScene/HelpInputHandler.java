package helpScene;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import player.Player;

public class HelpInputHandler {
	Player player;
	HelpScene scene;
	
	public HelpInputHandler(Player player,HelpScene scene) {
		this.player = player;
		this.scene = scene;
	}


	public void keyReleased(KeyEvent evt) {
		KeyCode key = evt.getCode();  // keyboard code for the pressed key
	       if (key == KeyCode.LEFT) {  // left arrow key
	            player.moveLeft(false);
	            scene.left = false;
	       }
	       if (key == KeyCode.RIGHT) {  // right arrow key
	            player.moveRight(false);
	            scene.right = false;
	       }
	       if (key == KeyCode.SHIFT) {
	    	   player.setShift(false);
	    	   scene.shift = false;
	       }
	       if (key == KeyCode.SPACE) {
	        	scene.space = false;
	       }
	       if(key == KeyCode.A) {
	        	scene.a = false;
	        }
		}
	
	public void keyPressed(KeyEvent evt) {
		KeyCode key = evt.getCode();  // keyboard code for the pressed key			
		if (key == KeyCode.SPACE) {
	    	   player.jumping(true);
	    	   scene.space = true;
	       }
        if (key == KeyCode.LEFT) {  // left arrow key
            player.moveLeft(true);
            scene.left = true;
        }
        if (key == KeyCode.RIGHT) {  // right arrow key
            player.moveRight(true);
            scene.right = true;
        }
        if (key == KeyCode.SHIFT) {
        	player.setShift(true);
        	scene.shift = true;
        }
        if(key == KeyCode.A) {
        	player.initAttack(true);
        	scene.a = true;
        }
        
	}
}
