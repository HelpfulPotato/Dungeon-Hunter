package Structure.Object;

import Structure.Basic.Attribute;
import Structure.Basic.GameObject;
import Structure.Basic.Transform;
import Enum.Tag;

abstract public class Enemy extends GameObject {
    public Enemy(String[] imagePaths, Transform transform, Attribute attribute) {
        super(Tag.enemy, imagePaths, transform, attribute);
    }
}
