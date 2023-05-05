package collisionTests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import collision.CircleCollision;
import collision.SphereHitBox;
import player.Player;

/**
 * Tests for collion.
 */
public class CollisionTest {
	/**
	 * tests the collsion with self
	 */
	@Test
	void testSelfCollision() {
		Player player = new Player(0,0);
		double r = player.getHitBox().getR();
		SphereHitBox hb = new SphereHitBox(player, r);
		
		//collision with self
		assertTrue(CircleCollision.collides(player.getHitBox(), hb));
	}

	/**
	 * tests that circles collides properly
	 */
	@Test
	void testCircleCollsion() {
		Player p1 = new Player(0, 0);
		Player p2 = new Player(0,0);

		//checks if two players collides when on same coordinates
		assertTrue(CircleCollision.collides(p1.getHitBox(), p2.getHitBox()));

		//checks if two players collides when 1px inside eachothers spheres
		Player p3 = new Player(p1.getHitBox().getR()-1,0);
		assertTrue(CircleCollision.collides(p1.getHitBox(), p3.getHitBox()));

		//checks that two players dont collides when outside each others radius
		Player p4 = new Player(p1.getHitBox().getR(),0);
		assertFalse(CircleCollision.collides(p1.getHitBox(), p4.getHitBox()));
		
		
	}
}
