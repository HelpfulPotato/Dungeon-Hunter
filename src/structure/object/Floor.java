package Structure.Object;

import Structure.Basic.GameObject;
import Structure.Basic.Transform;
import Enum.Tag;

abstract public class Floor extends GameObject {
    public final static int changeRate = 2;

    // used to generate custom floors when needed
    public Floor(String[] imagePaths, Transform transform) {
        super(Tag.floor, imagePaths, transform);
    }
}
