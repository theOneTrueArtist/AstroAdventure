package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class BackgroundElements extends AbstractObject{

    String sprite;
    public BackgroundElements(double x, double y, double h, double w, double degree, String sprite) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.deg = degree;
        this.sprite = sprite;
        this.hb = new SphereHitBox(this,0);
    }

    @Override
    public Image getSprite() {
        return ImageLoader.getImage("/sprites/background_elements/" + this.sprite + ".png");
    }

    @Override
    public void move() {

    }
}
