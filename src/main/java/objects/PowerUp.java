package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class PowerUp extends AbstractObject {

    public PowerUp(double x, double y, double degree) {
        this.x = x;
        this.y = y;
        this.w = 50;
        this.h = 50;
        this.deg = degree;
        this.hb = new SphereHitBox(this,40);
    }

    @Override
    public Image getSprite() {
        return ImageLoader.getImage("/sprites/other_assets/Other Sprites/EnergyPack.png");
    }

    @Override
    public void move() {

    }
}
