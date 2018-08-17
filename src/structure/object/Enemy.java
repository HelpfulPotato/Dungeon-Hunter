package structure.object;

import structure.basic.Attribute;
import structure.basic.GameObject;
import enums.Tag;
import structure.basic.Transform;

abstract public class Enemy extends GameObject {
    public Enemy(String[] imagePaths, Transform transform, Attribute attribute) {
        super(Tag.enemy, imagePaths, transform, attribute);
    }
}
