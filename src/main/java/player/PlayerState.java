package player;

public enum PlayerState {
	idle, run;
	
	public static PlayerState getState(Player player) {
		if(player.isRunning()){
			return run;
		}
		else {
			return idle;
		}
	}
}
