package collision;

public interface IHitBox {

    /**
     * Checks if hitbox intersects with target
     * @param target other hitbox
     * @return false or true depending on whether the two hitboxes intersect
     */
    public boolean intersects(IHitBox target);
}
