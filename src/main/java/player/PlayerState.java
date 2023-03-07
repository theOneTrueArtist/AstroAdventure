package player;

public enum PlayerState {
	idle, run, jump, fall, dead, crouch, slide;
	
	public static PlayerState getState(Player player) {
		player.setFrameCount(0);
		if (!player.isAlive()) {
			return dead;
		}
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
		case dead:
			return player.isAlive();
		case slide:
			return player.isjumping() || !player.isGrounded() || !player.isAlive()||player.getFrameCount() > 71;
		case crouch:
			return player.isjumping() || !player.isGrounded() || !player.isAlive() || player.isRunning() || !player.isCrouching();
		default:
			return true;
		}
	}
}
