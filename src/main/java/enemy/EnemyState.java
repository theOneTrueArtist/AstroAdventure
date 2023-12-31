package enemy;

public enum EnemyState {
	idle, run, jump, fall, dead, crouch, slide;

	/**
	 * gets a new state based on enemy action
	 * @param enemy
	 * @return EnemyState
	 */
	
	public static EnemyState getState(Enemy enemy) {
		enemy.setFrameCount(0);
		if (!enemy.isAlive()) {
			return dead;
		}
		if (enemy.isjumping()) {
			enemy.setGrounded(false);
			return jump;
		}
		if(enemy.isRunning()){
			return run;
		}

		if (!enemy.isGrounded()) {
			return fall;
		}
		
		return idle;
	}

	/**
	 * cheeks if the current state is done
	 * @param enemy
	 * @return true if state is over false otherwise
	 */
	public boolean isOver(Enemy enemy) {
		switch(this) {
		case idle:
			return !enemy.isGrounded() || enemy.isjumping() || !enemy.isAlive() || enemy.isRunning();
		case run:
			return !enemy.isGrounded() || enemy.isjumping() || !enemy.isAlive() || !enemy.isRunning();
		case jump:
			return !enemy.isGrounded() || !enemy.isjumping();
		case dead:
			return enemy.isAlive();
		default:
			return true;
		}
	}
}