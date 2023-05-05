package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

/**
 * Represents the powerup: Powercell. Part of the powerups.
 */
public class PowerCell extends AbstractPowerUp {

    public PowerCell(double x, double y, double degree) {
        this.x = x;
        this.y = y;
        this.h = 50;
        this.w = 50;
        this.deg = degree;
        this.hb = new SphereHitBox(this,40);
    }
    
    @Override
    public Image getSprite() {
        return ImageLoader.getImage("/sprites/other_assets/Other Sprites/EnergyPack.png");
    }

    @Override
    public void move() {}

    @Override
    public double productSpeed() {
        return 2;
    }

    @Override
    public double productHealth() {
        return 1;
    }

    @Override
    public double productHeight() {
        return 1;
    }

    @Override
    public double productWidth() {
        return 1;
    }

    @Override
    public double productAir() {
        return 1;
    }

}
