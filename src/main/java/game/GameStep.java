package game;

import collision.CircleCollision;
import enemy.Enemy;
import gravity.SphereGravity;
import levels.Level;
import objects.Coins;
import objects.GameActor;
import objects.IGameObject;

import objects.IPowerUp;
import player.Player;
import player.PlayerStats;

import java.util.ArrayList;


public class GameStep {
	static int coinsCollected = 0;
	public static boolean powerUp = false;
	public static void step(Game game, Player player, Level level) {
		//set gravity
		player.setGravity(null);
		for (SphereGravity gravity : level.getGravities()) {
			if (CircleCollision.collides(player.getHitBox(),gravity.getHitBox())) {
				player.setGravity(gravity);
			}
			for (GameActor actor : level.getEnemies()) {
				if (CircleCollision.collides(actor.getHitBox(),gravity.getHitBox())) {
					actor.setGravity(gravity);
				}
			}
		}
		//step actors
		player.step();
		player.setGrounded(false);
		for (GameActor actor: level.getEnemies()) {
			actor.setGrounded(false);
			actor.step();
		}
		//check collision
		for (IGameObject obj : level.getObjects()) {
			obj.move();
			if (CircleCollision.collides(player.getHitBox(), obj.getHitBox())) {
				double deg = 180 + Math.toDegrees(Math.atan2(player.getX() - obj.getX(), player.getY() - obj.getY()));
				double r = deg*Math.PI/180;
				double dist = (player.getHitBox().getR()/2 + obj.getHitBox().getR()/2)-1;
				double x = obj.getX() - Math.sin(r) * dist;
				double y = obj.getY() - Math.cos(r) * dist;
				player.moveTo(x,y);
				player.setGrounded(true);
			}
			
			for(GameActor actor : level.getEnemies()) {
				if (CircleCollision.collides(actor.getHitBox(), obj.getHitBox())) {
					double deg = 180 + Math.toDegrees(Math.atan2(actor.getX() - obj.getX(), actor.getY() - obj.getY()));
					double r = deg * Math.PI / 180;
					double dist = (actor.getHitBox().getR() / 2 + obj.getHitBox().getR() / 2) - 1;
					double x = obj.getX() - Math.sin(r) * dist;
					double y = obj.getY() - Math.cos(r) * dist;
					actor.moveTo(x, y);
					actor.setGrounded(true);
				}
			}
		}
		
		for (Enemy enemy : level.getEnemies()) {
			enemy.setTarget(player);
			if (CircleCollision.collides(enemy.getHitBox(), player.getHitBox())) {
				player.takeDamage();
			}
		}
		
		for (IGameObject obj : new ArrayList<IGameObject>(level.getCollectibles())) {
			if (CircleCollision.collides(player.getHitBox(), obj.getHitBox())) {
				coinsCollected++;
				level.removeCollectible(obj);
			}
		}
		for (IPowerUp obj : new ArrayList<IPowerUp>(level.getPowerUps())) {
			if (CircleCollision.collides(player.getHitBox(), obj.getHitBox())) {
				powerUp = true;
				player.givePowerUp(obj);
				level.removePowerup(obj);
			}
		}
	}
}
