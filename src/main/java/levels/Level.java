package levels;

import java.util.ArrayList;
import java.util.Objects;

import gravity.SphereGravity;
import objects.*;

@SuppressWarnings("unused")
public class Level {
	private ArrayList<IGameObject> objects;
	private ArrayList<GameActor> enemies;
	private ArrayList<SphereGravity> gravity;
	private ArrayList<IGameObject> background_environment;
	private ArrayList<IGameObject> collectibles;
	private ArrayList<IGameObject> powerups;
	
	public Level() {
		this.objects = new ArrayList<>();
		this.enemies = new ArrayList<>();
		this.gravity = new ArrayList<>();
		this.background_environment = new ArrayList<>();
		this.collectibles = new ArrayList<>();
		this.powerups = new ArrayList<>();

		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(-800,0));
		points.add(new Point(-1600, 0));
		points.add(new Point(-800,-800));

		// Background elements (Trees, rocks, bushes, etc.)
		background_environment.add(new BackgroundElements(0, 120,200, 200,-5,"Tree1"));
		background_environment.add(new BackgroundElements(305, 174,200, 200,26,"Tree3"));
		background_environment.add(new BackgroundElements(130, 280,200, 200,-5,"Tree2"));
		background_environment.add(new BackgroundElements(0, 1280,200, 200,-175,"Tree1"));
		background_environment.add(new BackgroundElements(-536, 695,200, 200,-90,"Tree2"));
		background_environment.add(new BackgroundElements(600, 825,200, 200,115,"Tree3"));

		// Enemies (Npc)
		enemies.add(new Npc(400, 190));

		//Objects (Planets)
		objects.add(new Sphere(50, 700, 1000, 1));
		objects.add(new Sphere(1000, 1300, 300,2));
		objects.add(new Sphere(1300,300, 400,2));
		objects.add(new MovingSphere(-650,0,300, points));
		objects.add(new Sphere(2700, 450, 1100, 3));
		objects.add(new Sphere(-2200, 300, 400, 2));

		//Gravity
		gravity.add(new SphereGravity(objects.get(0), 1300));
		gravity.add(new SphereGravity(objects.get(1), 500));
		gravity.add(new SphereGravity(objects.get(2), 800));
		gravity.add(new SphereGravity(objects.get(3), 500));
		gravity.add(new SphereGravity(objects.get(4), 1400));
		gravity.add(new SphereGravity(objects.get(5), 700));

		//Collectibles
		collectibles.add(new Coins(-250,250,-30));
		collectibles.add(new Coins(350,250,30));
		collectibles.add(new Coins(600,550,72));
		collectibles.add(new Coins(150,1260,170));
		collectibles.add(new Coins(-480,850,72));

		//Power Up collectible
		powerups.add(new PowerUp(2700, -150, 0));
	}
	
	public ArrayList<IGameObject> getObjects(){
		return this.objects;
	}
	public ArrayList<GameActor> getEnemies(){
		return this.enemies;
	}
	public ArrayList<SphereGravity> getGravities(){
		return this.gravity;
	}
	public ArrayList<IGameObject> getBackground_environment() {return this.background_environment;}
	public ArrayList<IGameObject> getCollectibles() {return this.collectibles;}
	public ArrayList<IGameObject> getPowerUps() {return this.powerups;}
	public void removePowerup(IGameObject c) {powerups.remove(c);}
	public void removeCollectible(IGameObject c) {
		collectibles.remove(c);
	}
}
