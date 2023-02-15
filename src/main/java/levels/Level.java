package levels;

import java.util.ArrayList;

import gravity.SphereGravity;
import objects.IGameCharacter;
import objects.IGameObject;
import objects.Npc;
import objects.Sphere;

public class Level {
	private ArrayList<IGameObject> objects;
	private ArrayList<IGameCharacter> enemies;
	private ArrayList<SphereGravity> gravity;
	public Level() {
		this.objects = new ArrayList<>();
		this.enemies = new ArrayList<>();
		this.gravity = new ArrayList<>();
		
		
		objects.add(new Sphere(50, 700, 400));
		enemies.add(new Npc(0,300));
		gravity.add(new SphereGravity(50, 700, 1000));
	}
	
	public ArrayList<IGameObject> getObjects(){
		return this.objects;
	}
	public ArrayList<IGameCharacter> getEnemies(){
		return this.enemies;
	}
	public ArrayList<SphereGravity> getGravities(){
		return this.gravity;
	}
	
	
}
