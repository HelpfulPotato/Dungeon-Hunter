package prefab;

import model.Game;
import structure.basic.Attribute;
import structure.basic.GameObject;
import enums.Tag;
import enums.Rotation;
import structure.basic.Transform;
import structure.object.Enemy;
import structure.object.Unit;

import java.util.HashMap;

final public class Player extends Unit {

    // default constructor with default attribute and images
    public Player(Transform transform) {
        // double declaration of Hashmap here is fine
        // because this hashmap is only used to generate buffered images
        // after that, it is GCed.
        super(Tag.player, new HashMap<Rotation, String[]>() {{
            put(Rotation.up, new String[]{"../../pic/player/up1.png","../../pic/player/up2.png", "../../pic/player/up3.png","../../pic/player/up4.png" });
            put(Rotation.down, new String[]{"../../pic/player/down1.png", "../../pic/player/down2.png", "../../pic/player/down3.png", "../../pic/player/down4.png"});
            put(Rotation.left, new String[]{"../../pic/player/left1.png", "../../pic/player/left2.png", "../../pic/player/left3.png", "../../pic/player/left4.png"});
            put(Rotation.right, new String[]{"../../pic/player/right1.png", "../../pic/player/right2.png", "../../pic/player/right3.png", "../../pic/player/right4.png"});
        }}, transform, new Attribute(100, 100, 10, 10, 0, 0
                ,0,0,0,0,0,0));
    }

    // custom constructor
    public Player(HashMap<Rotation, String[]> imagePaths, Transform transform, Attribute attribute) {
        super(Tag.player, imagePaths, transform, attribute);
    }


}
