package objects;

import collision.SphereHitBox;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.image.Image;

public class PowerCell implements IPowerUp {
    double x, y, degree;
    
    String sprite;
    SphereHitBox hb = new SphereHitBox(this,40);
    double h = 50;
    double w = 50;

    public PowerCell(double x, double y, double degree) {
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
        return ImageLoader.getImage("/sprites/other_assets/Other Sprites/EnergyPack.png");
    }

    @Override
    public SphereHitBox getHitBox() {
        return this.hb;
    }

    @Override
    public void move() {}

    @Override
    public double getDeg() {
        return this.degree;
    }

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
