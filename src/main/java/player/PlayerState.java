package player;

public enum PlayerState {
	idle, 
	run, jump, fall, 
	dead, 
	crouch, slide, 
	attack1, attack2, attack3,
	air_attack1, air_attack2,air_attack3;
	
	public static PlayerState getState(Player player) {
		player.setFrameCount(0);
		PlayerState s = transitionToState(player);
		if (s != null) return s;
		
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
		
		if (player.isAttacking()) {
			player.initAttack(false);
			return  player.isGrounded()? attack1 : air_attack1;
		}
		
		if(player.isRunning()){
			return run;
		}
		if (!player.isGrounded()) {
			return fall;
		}
		
		return idle;
	}
	static PlayerState transitionToState(Player player) {
		switch(player.getState()) {
		case attack1:
			if (player.isAttacking()) {
				player.initAttack(false);
				return attack2;
			}
			break;
		case attack2:
			if (player.isAttacking()) 
			{
				player.initAttack(false); 
				return attack3;
			}
			break;
		case air_attack1:
			if (player.isAttacking()) {
				player.initAttack(false); 
				return air_attack2;
			}
			break;
		case air_attack2:
			if(player.isAttacking()) {
				player.initAttack(false); 
				return air_attack3;
			}
			break;
		default:
			break;
		}
		return null;
	}
	public boolean isOver(Player player) {
		switch(this) {
		case idle:
			return !player.isGrounded() || player.isjumping() || !player.isAlive() || player.isRunning() || player.isCrouching() || player.isAttacking();
		case run:
			return !player.isGrounded() || player.isjumping() || !player.isAlive() || !player.isRunning() ||player.isCrouching() || player.isAttacking();
		case jump:
			return !player.isGrounded() || !player.isjumping();
		case fall:
			return player.isGrounded() || player.isAttacking();
		case dead:
			return player.isAlive();
		case slide:
			return player.isjumping() || !player.isGrounded() || !player.isAlive()||player.getFrameCount() > 71;
		case crouch:
			return player.isjumping() || !player.isGrounded() || !player.isAlive() || player.isRunning() || !player.isCrouching();
		case attack1: 
			if (player.getFrameCount() == 29) return true;
		case attack2: 
			if (player.getFrameCount() == 35) return true;
		case attack3:
			if (player.getFrameCount() == 47) return true;
			
			return !player.isGrounded();
		case air_attack1: 
			if (player.getFrameCount() == 23) return true;
		case air_attack2: 
			if (player.getFrameCount() == 17) return true;
		case air_attack3:
			
			return player.isGrounded();
		default:
			return true;
		}
	}
}
