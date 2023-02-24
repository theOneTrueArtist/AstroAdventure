package objects;

import javafx.scene.image.Image;


/**
 * This record-class takes in all values needed for a game entity, like HP, sprite, walkspeed etc.
 * To call on these values simply call on the EntityRecord-object with the needed variable.
 * @param HP double;
 * @param walkSpeed double;
 * @param runSpeed double;
 * @param width double;
 * @param height double;
 * @param jumpAbility boolean; Is the entity allowed to jump?
 * @param sprite Image; sprite of entity
 */
public record EntityRecord (double HP, double walkSpeed, double runSpeed, double width, double height, boolean jumpAbilty, Image sprite){

}
