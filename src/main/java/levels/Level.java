package levels;

import java.util.ArrayList;

import enemy.Enemy;
import gravity.SphereGravity;
import objects.*;


public class Level {
	private ArrayList<IGameObject> objects;
	private ArrayList<Enemy> enemies;
	private ArrayList<SphereGravity> gravity;
	private ArrayList<IGameObject> background_environment;
	private ArrayList<IGameObject> collectibles;
	private ArrayList<AbstractPowerUp> powerups;
    public Level(){
    	this.objects = new ArrayList<>();
 		this.enemies = new ArrayList<>();
 		this.gravity = new ArrayList<>();
 		this.background_environment = new ArrayList<>();
 		this.collectibles = new ArrayList<>();
 		this.powerups = new ArrayList<>();	 
    }
    
    public ArrayList<IGameObject> getObjects(){
 		return this.objects;
 	}
 	public ArrayList<Enemy> getEnemies(){
 		return this.enemies;
 	}
 	public ArrayList<SphereGravity> getGravities(){
 		return this.gravity;
 	}
 	public ArrayList<IGameObject> getBackground_environment() {
 		return this.background_environment;
 	}
 	public ArrayList<IGameObject> getCollectibles() {
 		return this.collectibles;
 	}
 	public ArrayList<AbstractPowerUp> getPowerUps() {
 		return this.powerups;
 	}
 	public void removePowerup(AbstractPowerUp c) {
 		powerups.remove(c);
 	}
 	public void removeCollectible(IGameObject c) {
 		collectibles.remove(c);
 	}
}
