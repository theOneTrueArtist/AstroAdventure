package levels;

import enemy.Enemy;
import gravity.SphereGravity;
import objects.AbstractPowerUp;
import objects.IGameObject;

import java.util.ArrayList;

/**
 * Represents the level. Contains all elements on the level.
 */
public class Level {
	private ArrayList<IGameObject> objects;
	private ArrayList<Enemy> enemies;
	private ArrayList<SphereGravity> gravity;
	private ArrayList<IGameObject> background_environment;
	private ArrayList<IGameObject> collectibles;
	private ArrayList<AbstractPowerUp> powerups;
	private ArrayList<IGameObject> portals;
    public Level(){
    	this.objects = new ArrayList<>();
 		this.enemies = new ArrayList<>();
 		this.gravity = new ArrayList<>();
 		this.background_environment = new ArrayList<>();
 		this.collectibles = new ArrayList<>();
 		this.powerups = new ArrayList<>();
		this.portals = new ArrayList<>();
    }
    
	/**
	 * @return Returns gameobjects. Of the type IGameObject
	 */
    public ArrayList<IGameObject> getObjects(){
 		return this.objects;
 	}

	/**
	 * @return Returns All enemies.
	 */
 	public ArrayList<Enemy> getEnemies(){
 		return this.enemies;
 	}
	/**
	 * @return Returns all Gravity spheres
	 */
 	public ArrayList<SphereGravity> getGravities(){
 		return this.gravity;
 	}
	/**
	 * @return Returns background Enviroment
	 */
 	public ArrayList<IGameObject> getBackground_environment() {
 		return this.background_environment;
 	}
	/**
	 * @return Returns all collectibles, like coins.
	 */
 	public ArrayList<IGameObject> getCollectibles() {
 		return this.collectibles;
 	}
	/**
	 * @return Returns all powerups.
	 */
 	public ArrayList<AbstractPowerUp> getPowerUps() {
 		return this.powerups;
 	}

	/**
	 * @return Returns all portals
	 */
	public ArrayList<IGameObject> getPortals() {
		return portals;
	}

	/**
	 * @return Removes powerup from the powerups. So that powerups are removed after pick up.
	 */
	public void removePowerup(AbstractPowerUp c) {
 		powerups.remove(c);
 	}
	/**
	 * @return Removes collecibles from collectible list. So that coins are removed after pick up.
	 */
 	public void removeCollectible(IGameObject c) {
 		collectibles.remove(c);
 	}
}
