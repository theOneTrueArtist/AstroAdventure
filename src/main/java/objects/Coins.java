package objects;

import collision.IHitBox;
import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class Coins implements IGameObject {
    double x, y, degree;

    String sprite;
    SphereHitBox hb = new SphereHitBox(this,40);
    double h = 50;
    double w = 50;

    public Coins(double x, double y, double degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
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
        return ImageLoader.getImage("/sprites/other_assets/Other Sprites/Diamond.png");
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
