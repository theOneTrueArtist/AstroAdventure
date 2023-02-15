package game;

import collision.CircleCollision;
import gravity.SphereGravity;
import levels.Level;
import player.Player;

public class GameStep {
	public static void step(Player player, Level level) {
		player.move();
		for (SphereGravity gravity : level.getGravities())
		if (CircleCollision.collides(player.getHitBox(),gravity.getHitBox())) {
			//System.out.println("kek");
			player.setGravity(gravity);
		}
	}
}
