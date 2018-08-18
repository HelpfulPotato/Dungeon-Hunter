package structure.object;

import structure.basic.GameObject;
import enums.Tag;
import structure.basic.Transform;

abstract public class Wall extends GameObject {


    public Wall(String[] imagePaths, Transform transform) {
        super(Tag.wall, imagePaths, transform);
    }
}
