package player;

public enum PlayerMovementState {
	idle, 
	run, jump, fall,  
	crouch, slide;
	
	public static PlayerMovementState getState(Player player) {
		if (player.actionState == null)
			player.setFrameCount(0);
		
		PlayerMovementState s = transitionToState(player);
		if (s != null) return s;
		
		
		if (player.isjumping()) {
			player.setGrounded(false);
			return jump;
		}
		if (player.isSliding()) {
			return slide;
		}
		if (player.isCrouching()) {
			return crouch;
		}
				
		if(player.isRunning()){
			return run;
		}
		if (!player.isGrounded()) {
			return fall;
		}
		
		return idle;
	}
	static PlayerMovementState transitionToState(Player player) {
		switch(player.getMovementState()) {
		default:
			break;
		}
		return null;
	}
	public boolean isOver(Player player) {
		switch(this) {
		case idle:
			return !player.isGrounded() || player.isjumping() || !player.isAlive() || player.isRunning() || player.isCrouching();
		case run:
			return !player.isGrounded() || player.isjumping() || !player.isAlive() || !player.isRunning() ||player.isCrouching();
		case jump:
			return !player.isGrounded() || !player.isjumping();
		case fall:
			return player.isGrounded();
		
		case slide:
			return player.isjumping() || !player.isGrounded() || !player.isAlive()||player.getFrameCount() > 71;
		case crouch:
			return player.isjumping() || !player.isGrounded() || !player.isAlive() || player.isRunning() || !player.isCrouching();
		default:
			return true;
		}
	}
}
