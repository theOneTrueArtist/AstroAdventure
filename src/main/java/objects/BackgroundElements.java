package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class BackgroundElements implements IGameObject{
    double x, y, h, w, degree;

    String sprite;
    SphereHitBox hb = new SphereHitBox(this,0);
    public BackgroundElements(double x, double y, double h, double w, double degree, String sprite) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.degree = degree;
        this.sprite = sprite;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getWidth() {
        return this.w;
    }

    @Override
    public double getHeight() {
        return this.h;
    }

    @Override
    public Image getSprite() {
        return ImageLoader.getImage("/sprites/background_elements/" + this.sprite + ".png");
    }

    @Override
    public SphereHitBox getHitBox() {
        return this.hb;
    }

    @Override
    public void move() {

    }

    @Override
    public double getDeg() {
        return this.degree;
    }
}
