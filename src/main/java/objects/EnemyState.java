package objects;

public enum EnemyState {
	idle, run, jump, fall, dead, crouch, slide;
	
	public static EnemyState getState(Npc enemy) {
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
	public boolean isOver(Npc enemy) {
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