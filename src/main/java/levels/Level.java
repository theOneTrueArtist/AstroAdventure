package levels;

import java.util.ArrayList;

import gravity.SphereGravity;
import objects.EntityRecord;
import objects.GameActor;
import objects.IGameObject;
import objects.MovingSphere;
import objects.Npc;
import objects.Point;
import objects.Sphere;
@SuppressWarnings("unused")
public class Level {
	private ArrayList<IGameObject> objects;
	private ArrayList<GameActor> enemies;
	private ArrayList<SphereGravity> gravity;
	
	public Level() {
		this.objects = new ArrayList<>();
		this.enemies = new ArrayList<>();
		this.gravity = new ArrayList<>();
		
		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(0,0));
		points.add(new Point(-1000, 600));
		points.add(new Point(-600,0));
		
		enemies.add(new Npc(30, 30));
		
		objects.add(new Sphere(50, 700, 400, 1));
		objects.add(new Sphere(800, 900, 200,1));
		objects.add(new Sphere(1300,300, 400,1));
		objects.add(new MovingSphere(0,0,300, points));
		objects.add(new Sphere(2700, 450, 1100, 1));
		//enemies.add(new Npc(0,300));
		gravity.add(new SphereGravity(objects.get(0), 1000));
		gravity.add(new SphereGravity(objects.get(1), 700));
		gravity.add(new SphereGravity(objects.get(2), 800));
		gravity.add(new SphereGravity(objects.get(3), 500));
		gravity.add(new SphereGravity(objects.get(4), 1400));
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
	
	
}
