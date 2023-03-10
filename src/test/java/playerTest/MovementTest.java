package playerTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import player.Player;
import player.PlayerState;

public class MovementTest {
	
	@Test
	void testPlayerIdleMovement(){
		Player player = new Player(0,0);
		
		double prevX = player.getX();
		double prevY = player.getY();
		
		PlayerState state = player.getState();
		
		//if playerstate is idle the character should not move
		assertTrue(state == PlayerState.idle);
		
		player.move();
		
		assertTrue(prevX == player.getX() && prevY == player.getY());
	}
	
	@Test
	void testPlayerRunMovement(){
		Player player = new Player(0,0);
		
		double prevX = player.getX();
		double prevY = player.getY();
		
		//if playerstate should start off idle
		assertTrue(player.getState() == PlayerState.idle);
		
		player.moveLeft(true);
		player.setGrounded(true);
		
		player.step();
		
		assertTrue(player.getState() == PlayerState.run);
		
		//player has moved if x is not equal to previous x
		assertTrue(prevX != player.getX());
	}
	
	
}
