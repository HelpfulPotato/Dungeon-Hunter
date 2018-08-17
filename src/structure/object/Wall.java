package Structure.Object;

import Structure.Basic.GameObject;
import Structure.Basic.Transform;
import Enum.Tag;

abstract public class Wall extends GameObject {


    public Wall(String[] imagePaths, Transform transform) {
        super(Tag.wall, imagePaths, transform);
    }
}
