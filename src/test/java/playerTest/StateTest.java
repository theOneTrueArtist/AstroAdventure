package playerTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import player.Player;
import player.PlayerMovementState;

public class StateTest {
	/**
	 * tests player runstate turns on when prompted
	 */
	@Test
	void testSetRunState() {
		Player player = new Player(0,0);
		
		//player state should start off idle
		assertTrue(player.getMovementState() == PlayerMovementState.idle);
		
		//player told to move left and that it is grounded
		player.moveLeft(true);
		player.setGrounded(true);
		
		//player is running
		assertTrue(player.isRunning());
		
		player.step();
		//player state is set to run
		assertTrue(player.getMovementState() == PlayerMovementState.run);	
	}

	/**
	 * tests that player runstate turns off when prompted
	 */
	void testSetNotRunState() {
		Player player = new Player(0,0);
		
		//player state should start off idle
		assertTrue(player.getMovementState() == PlayerMovementState.idle);
		
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
		assertTrue(player.getMovementState() != PlayerMovementState.run);	
	}

	/**
	 * tests that initial state is idle
	 */
	void testStartState() {
		Player player = new Player(0,0);
		assertTrue(player.getMovementState() == PlayerMovementState.idle);
	}
	
}
