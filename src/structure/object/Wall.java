package structure.object;

import structure.basic.GameObject;
import structure.basic.Transform;
import enums.Tag;

abstract public class Wall extends GameObject {


    public Wall(String[] imagePaths, Transform transform) {
        super(Tag.wall, imagePaths, transform);
    }
}
