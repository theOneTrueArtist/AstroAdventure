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
			obj.move();
			if (CircleCollision.collides(player.getHitBox(), obj.getHitBox())) {
				double deg = 180 + Math.toDegrees(Math.atan2(player.getX() - obj.getX(), player.getY() - obj.getY()));
				double r = deg*Math.PI/180;
				double dist = (player.getHitBox().getR()/2 + obj.getHitBox().getR()/2)-1;
				double x = obj.getX() - Math.sin(r) * dist;
				double y = obj.getY() - Math.cos(r) * dist;
				player.moveTo(x,y );
				player.setGrounded(true);
			}
		}
	}
}
