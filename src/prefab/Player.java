package FinalObject;

import Structure.Basic.Attribute;
import Structure.Basic.GameObject;
import Enum.Tag;
import Structure.Basic.Transform;
import Enum.Rotation;

import java.util.HashMap;

final public class Player extends GameObject {

    // default constructor with default attribute and images
    public Player(Transform transform) {
        // double declaration of Hashmap here is fine
        // because this hashmap is only used to generate buffered images
        // after that, it is GCed.
        super(Tag.player, new HashMap<Rotation, String[]>() {{
            put(Rotation.up, new String[]{""});
            put(Rotation.down, new String[]{""});
            put(Rotation.left, new String[]{""});
            put(Rotation.right, new String[]{""});
        }}, transform, new Attribute(100, 10, 10, 0f));
    }

    // custom constructor
    public Player(HashMap<Rotation, String[]> imagePaths, Transform transform, Attribute attribute) {
        super(Tag.player, imagePaths, transform, attribute);
    }
}
