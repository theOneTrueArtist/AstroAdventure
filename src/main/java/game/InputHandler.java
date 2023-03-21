package game;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import player.Player;

public class InputHandler {
	Player player;
		
	public InputHandler(Player player) {
		this.player = player;
	}
		
		
	public void keyReleased(KeyEvent evt) {
		KeyCode key = evt.getCode();  // keyboard code for the pressed key
	       if (key == KeyCode.LEFT) {  // left arrow key
	            player.moveLeft(false);
	       }
	       if (key == KeyCode.RIGHT) {  // right arrow key
	            player.moveRight(false);
	       }
	       if (key == KeyCode.SHIFT) {
	    	   player.setShift(false);
	       }
	       if (key == KeyCode.SHIFT) {
	        	player.setShift(false);
	       }
		}
	
	public void keyPressed(KeyEvent evt) {
		KeyCode key = evt.getCode();  // keyboard code for the pressed key			
		if (key == KeyCode.SPACE) {
	    	   player.jumping(true);
	       }
		if (key == KeyCode.R) {
			player.setHp(0);
		}
        if (key == KeyCode.LEFT) {  // left arrow key
            player.moveLeft(true);
        }
        if (key == KeyCode.RIGHT) {  // right arrow key
            player.moveRight(true);
        }
        if (key == KeyCode.SHIFT) {
        	player.setShift(true);
        }
        if(key == KeyCode.A) {
        	player.initAttack(true);
        }
        
	}
}
