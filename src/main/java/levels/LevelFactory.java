package levels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import enemy.Enemy;
import gravity.SphereGravity;
import objects.*;


public final class LevelFactory {
	
	private LevelFactory() {};
	
	public static Level produce (String filename) {
		
		Level level = new Level();
		
		File file = new File("src//main//java//levels//" + filename);
		
		Scanner myReader;

		try {
			myReader = new Scanner(file);
			
			try {
				//Objects
				while (true) {
					String data = myReader.nextLine();
					if (data.charAt(0) == '>'){
						break;
					}
					String[] nums = data.split(" ", 0);
					level.getObjects().add(new Sphere(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), Double.parseDouble(nums[2]), Integer.parseInt(nums[3])));
				}
				//Moving Objects
				while (true) {
					String data = myReader.nextLine();
					if (data.charAt(0) == '>'){
						break;
					}
					String sphere = myReader.nextLine();
					String[] pointNums = data.split(" ", 0);
					String[] sphereNums = sphere.split(" ", 0);
					
					ArrayList<Point> points = new ArrayList<>();
					for (int i = 0; i < pointNums.length; i+=2) {
						points.add(new Point(Double.parseDouble(pointNums[i]), Double.parseDouble(pointNums[i+1])));
					}
					level.getObjects().add(new MovingSphere(Double.parseDouble(sphereNums[0]), Double.parseDouble(sphereNums[1]), Double.parseDouble(sphereNums[2]), points));
					
				}
				//Gravity
				while (true) {
					String data = myReader.nextLine();
					if (data.charAt(0) == '>'){
						break;
					}
					String[] nums = data.split(" ", 0);
					level.getGravities().add(new SphereGravity(level.getObjects().get(Integer.parseInt(nums[0])), Double.parseDouble(nums[1])));
					
				}
				//Background elements
				while (true) {
					String data = myReader.nextLine();
					if (data.charAt(0) == '>'){
						break;
					}
					String[] nums = data.split(" ", 0);
					level.getBackground_environment().add(new BackgroundElements(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), Double.parseDouble(nums[2]), Double.parseDouble(nums[3]), Double.parseDouble(nums[4]), nums[5]));
					
				}
				//collectables
				while (true) {
					String data = myReader.nextLine();
					if (data.charAt(0) == '>'){
						break;
					}
					String[] nums = data.split(" ", 0);
					level.getCollectibles().add(new Coins(Double.parseDouble(nums[0]),Double.parseDouble(nums[1]),Double.parseDouble(nums[2])));
					
				}
				//power-ups -

				while (true) {
					String data = myReader.nextLine();
					if (data.charAt(0) == '>'){
						break;
					}
					String[] nums = data.split(" ", 0);
					level.getPowerUps().add(new PowerCell(Double.parseDouble(nums[0]),Double.parseDouble(nums[1]),Double.parseDouble(nums[2])));
					
				}
				//enemy
				while (true) {
					String data = myReader.nextLine();
					if (data.charAt(0) == '>'){
						break;
					}
					String[] nums = data.split(" ", 0);
					level.getEnemies().add(new Enemy(Double.parseDouble(nums[0]),Double.parseDouble(nums[1])));
					
				}
				//portal
				while (true) {
					String data = myReader.nextLine();
					if (data.charAt(0) == '>'){
						break;
					}
					String[] nums = data.split(" ", 0);
					level.getPortals().add(new EndPortal(Double.parseDouble(nums[0]),Double.parseDouble(nums[1]),Double.parseDouble(nums[2])));

				}
			}
			catch(NoSuchElementException e) {
				System.out.println("File structure leads to errors");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File has not been found");
		}
		return level;
	}
	
	
	
}
