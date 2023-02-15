package game;

import collision.CircleCollision;
import gravity.SphereGravity;
import levels.Level;
import objects.IGameObject;
import player.Player;

public class GameStep {
	public static void step(Player player, Level level) {
		player.move();
		for (SphereGravity gravity : level.getGravities()) {
			if (CircleCollision.collides(player.getHitBox(),gravity.getHitBox())) {
			player.setGravity(gravity);
			}
		}
		player.setGrounded(false);
		for (IGameObject obj : level.getObjects()) {
			if (CircleCollision.collides(player.getHitBox(), obj.getHitBox())) {
				player.setGrounded(true);
			}
		}
	}
}
