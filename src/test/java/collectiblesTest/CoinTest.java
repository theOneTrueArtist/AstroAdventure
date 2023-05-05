package collectiblesTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import objects.Coins;
import org.junit.jupiter.api.Test;
import collision.CircleCollision;
import player.Player;

/**
 * Tests or coins.
 */
public class CoinTest {

    /**
     * Tests the collision between the player and coins.
     */
    @Test
    void testCoinCollision() {
        Player player = new Player(0,0);
        Coins coins = new Coins(0,0,0);

        assertTrue(CircleCollision.collides(player.getHitBox(), coins.getHitBox()));
    }
}
