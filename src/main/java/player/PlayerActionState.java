package player;

public enum PlayerActionState {
	attack1, attack2, attack3,
	air_attack1, air_attack2,air_attack3,
	dead;

	/**
	 * function that returns a action state for the player.
	 * @param player
	 * @return A PlayerActionState
	 */
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

	/**
	 * function that finds what state to transition to after a state is completed
	 * @param player
	 * @return new PlayerActionState
	 */
	
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

	/***
	 * checks wheter a actionstate is over.
	 * @param player
	 * @return boolean, false if state is not over true otherwise.
	 */
	
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
