package structure.object;

import structure.basic.Attribute;
import structure.basic.GameObject;
import structure.basic.Transform;
import enums.Tag;

abstract public class Enemy extends GameObject {
    public Enemy(String[] imagePaths, Transform transform, Attribute attribute) {
        super(Tag.enemy, imagePaths, transform, attribute);
    }
}
