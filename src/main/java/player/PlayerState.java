package player;

public enum PlayerState {
	idle, run, jump, fall;
	
	public static PlayerState getState(Player player) {
		if (player.isjumping()) {
			return jump;
		}
		else if(player.isRunning()){
			return run;
		}
		else if (!player.isGrounded()) {
			return fall;
		}
		else {
			return idle;
		}
	}
}
