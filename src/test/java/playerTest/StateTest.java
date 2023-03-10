package playerTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import player.Player;
import player.PlayerState;

public class StateTest {
	@Test
	void testSetRunState() {
		Player player = new Player(0,0);
		
		//player state should start off idle
		assertTrue(player.getState() == PlayerState.idle);
		
		//player told to move left and that it is grounded
		player.moveLeft(true);
		player.setGrounded(true);
		
		//player is running
		assertTrue(player.isRunning());
		
		player.step();
		//player state is set to run
		assertTrue(player.getState() == PlayerState.run);	
	}
	
	void testSetNotRunState() {
		Player player = new Player(0,0);
		
		//player state should start off idle
		assertTrue(player.getState() == PlayerState.idle);
		
		//player told to move left and that it is grounded
		player.moveLeft(true);
		player.setGrounded(true);
		
		//player is running
		assertTrue(player.isRunning());
		
		player.step();
		player.moveLeft(false);
		player.setGrounded(false);
		player.step();
		//player state is not set to run
		assertTrue(player.getState() != PlayerState.run);	
	}
	void testStartState() {
		Player player = new Player(0,0);
		assertTrue(player.getState() == PlayerState.idle);
	}
	
}
