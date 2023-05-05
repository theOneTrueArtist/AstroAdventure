package portalTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import objects.EndPortal;
import org.junit.jupiter.api.Test;
import collision.CircleCollision;
import player.Player;


/** Tests the portal. */
public class PortalTest {
    /**
     * Tests the collision between the player and portals.
     */
    @Test
    void testPortalCollision() {
        Player player = new Player(0,0);
        EndPortal portal = new EndPortal(0,0,0);

        assertTrue(CircleCollision.collides(player.getHitBox(), portal.getHitBox()));
    }
}
