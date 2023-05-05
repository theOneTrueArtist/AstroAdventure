package collectiblesTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.scene.shape.Circle;
import objects.Coins;
import objects.PowerCell;
import org.junit.jupiter.api.Test;

import collision.CircleCollision;
import collision.SphereHitBox;
import player.Player;


public class CoinTest {

    /**
     * Tests the collision between the player and coins.
     */
    @Test
    void testPlayerCollision() {
        Player player = new Player(0,0);
        Coins coins = new Coins(0,0,0);

        assertTrue(CircleCollision.collides(player.getHitBox(), coins.getHitBox()));
    }
}
