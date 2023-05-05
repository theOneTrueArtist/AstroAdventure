package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

/*
 * Represents the collectible coins found in the game.
 */
public class Coins extends AbstractObject {

    public Coins(double x, double y, double degree) {
        this.x = x;
        this.y = y;
        this.deg = degree;
        this.w = 50;
        this.h = 50;
        this.hb = new SphereHitBox(this,40);
    }

    @Override
    public Image getSprite() {
        return ImageLoader.getImage("/sprites/other_assets/Other Sprites/Diamond.png");
    }

    @Override
    public void move() {

    }
}
