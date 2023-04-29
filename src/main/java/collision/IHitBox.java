package collision;

import javafx.scene.shape.Shape;

public interface IHitBox {



    /**
     * Checks if hitbox intersects with target
     * @param target other hitbox
     * @return false or true depending on whether the two hitboxes intersect
     */
    public boolean intersects(IHitBox target);


    /**
     * @return Returns x-coordinate of hitbox
     */
    public double getX();

    /**
     * @return Returns y-coordinate of hitbox
     */
    public double getY();

    /**
     * @return Returns the shape of the hitbox
     */
    public Shape getShape();
}
