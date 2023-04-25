package player;

public enum PlayerActionState {
	attack1, attack2, attack3,
	air_attack1, air_attack2,air_attack3,
	dead;
	public static PlayerActionState getState(Player player) {
		if (!player.isAlive()) {
			return dead;
		}
		if (player.actionState != null) {
			PlayerActionState s = transitionToState(player);
			if (s != null) return s;
		}
		if (player.isAttacking()) {
			player.initAttack(false);
			player.setFrameCount(0);
			return  player.isGrounded()? attack1 : air_attack1;
		}
		return null;
	}
	
	static PlayerActionState transitionToState(Player player) {
		switch(player.actionState) {
		case attack1:
			if (player.isAttacking()) {
				player.setFrameCount(0);
				player.initAttack(false);
				return attack2;
			}
			break;
		case attack2:
			if (player.isAttacking()) 
			{
				player.setFrameCount(0);
				player.initAttack(false); 
				return attack3;
			}
			break;
		case air_attack1:
			if (player.isAttacking()) {
				player.setFrameCount(0);
				player.initAttack(false); 
				return air_attack2;
			}
			break;
		case air_attack2:
			if(player.isAttacking()) {
				player.setFrameCount(0);
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
		case dead:
			return player.isAlive();
		}
		return true;
	}

}
