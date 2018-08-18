package structure.object;

import structure.basic.GameObject;
import enums.Tag;
import structure.basic.Transform;

abstract public class Floor extends GameObject {
    // used to generate custom floors when needed
    public Floor(String[] imagePaths, Transform transform) {
        super(Tag.floor, imagePaths, transform);
    }
}
