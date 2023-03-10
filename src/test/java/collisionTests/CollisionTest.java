package collisionTests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import collision.CircleCollision;
import collision.SphereHitBox;
import player.Player;


public class CollisionTest {
	@Test
	void testSelfCollision() {
		Player player = new Player(0,0);
		double r = player.getHitBox().getR();
		SphereHitBox hb = new SphereHitBox(player, r);
		
		//collision with self
		assertTrue(CircleCollision.collides(player.getHitBox(), hb));
	}
	
	@Test
	void testCircleCollsion() {
		Player p1 = new Player(0, 0);
		Player p2 = new Player(0,0);
		
		assertTrue(CircleCollision.collides(p1.getHitBox(), p2.getHitBox()));
	
		Player p3 = new Player(p1.getHitBox().getR()-1,0);
		assertTrue(CircleCollision.collides(p1.getHitBox(), p3.getHitBox()));
		
		Player p4 = new Player(p1.getHitBox().getR(),0);
		assertFalse(CircleCollision.collides(p1.getHitBox(), p4.getHitBox()));
		
		
	}
}
