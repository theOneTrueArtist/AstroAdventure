package objects;

public abstract class AbstractPowerUp extends AbstractObject{
    /**
     * speed is a percent based value
     * @return double speed to be changed by
     */
    public abstract double productSpeed();
    /**
     * health is a percent based value
     * @return double health to be changed by
     */

    public abstract double productHealth();
    /**
     * height is a percent based value
     * @return double height to be changed by
     */

    public abstract double productHeight();
    /**
     * width is a percent based value
     * @return double width to be changed by
     */

    public abstract double productWidth();

    /**
     * air is a percent based value
     * @return double air to be changed by
     */
    public abstract double productAir();

}
