package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class EndPortal extends AbstractObject {

    int frameCount = 0;
    public EndPortal(double x, double y, double degree) {
        this.x = x;
        this.y = y;
        this.deg = degree;
        this.w = 150;
        this.h = 150;
        this.hb = new SphereHitBox(this, 20);
    }

    @Override
    public Image getSprite() {
        return ImageLoader.getImage("/sprites/EndPortalSprites/tile0" + frameCount / 6 % 20 + ".png");
    }

    @Override
    public void move() {
        frameCount++;
    }
}
