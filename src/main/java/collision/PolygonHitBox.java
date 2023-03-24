package collision;

import javafx.scene.shape.Polygon;
import objects.IGameObject;

public class PolygonHitBox implements IHitBox{

	IGameObject target;
	double[] coordinates; // An array of the coordinates to corners of the polygon hitbox, the format is: (x_1, y_1, x_2, y_2, x_3, y_3 ...)

    Polygon hitbox;



	public PolygonHitBox(IGameObject target, double[] coordinates) {
		this.target = target;
		this.coordinates = coordinates;
        this.hitbox = new Polygon( coordinates);
	}

    public double[] getCoordinates(){
        return this.coordinates;
    }

    public Polygon getPolygon(){
        return hitbox;
    }

    @Override //not done
    public boolean intersects(IHitBox target) {
        return false;
    }


}
