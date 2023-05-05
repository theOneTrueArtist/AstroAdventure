package collision;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import objects.IGameObject;

public class SquareHitbox implements IHitBox{
    IGameObject target;
    double w;
    double h;
    Rectangle box;

    public SquareHitbox(IGameObject target, double w, double h) {
        this.target = target;
        this.w = w;
        this.h = h;

        this.box = new Rectangle(getX(), getY(), this.w, this.h); 


    }
    
    public double getWidth() {
        return this.w;
    }
    public double getHeight() {
        return this.h;
    }
    @Override
    public double getX() {
        return target.getX();
    }
    @Override
    public double getY() {
        return target.getY();
    }

    @Override
    public Shape getShape(){
        return this.box;
    }

    @Override
    public boolean intersects(IHitBox target) {
        Shape newBox = target.getShape();
        Shape interShape = Shape.intersect(this.box, newBox);      
        return 0 < interShape.getBoundsInLocal().getWidth();
    }
}
