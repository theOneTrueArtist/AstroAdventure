package powerUpTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.scene.shape.Circle;
import objects.PowerCell;
import org.junit.jupiter.api.Test;

import collision.CircleCollision;
import collision.SphereHitBox;
import player.Player;


public class PowerCellTest {
    /**
     * Tests the collision between the player and power ups.
     */
    @Test
    void testPlayerCollision() {
        Player player = new Player(0,0);
        PowerCell powerCell = new PowerCell(0,0,0);

        assertTrue(CircleCollision.collides(player.getHitBox(), powerCell.getHitBox()));
    }
}
