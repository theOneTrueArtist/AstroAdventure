package powerUpTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import objects.PowerCell;
import org.junit.jupiter.api.Test;
import collision.CircleCollision;
import player.Player;


public class PowerCellTest {
    /**
     * Tests the collision between the player and power ups.
     */
    @Test
    void testPowerCellCollision() {
        Player player = new Player(0,0);
        PowerCell powerCell = new PowerCell(0,0,0);

        assertTrue(CircleCollision.collides(player.getHitBox(), powerCell.getHitBox()));
    }
}
