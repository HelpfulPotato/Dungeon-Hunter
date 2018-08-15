package Structure.Object;

import Structure.Attribute;
import Structure.GameObject;
import Enum.Tag;
import Structure.Sprite;
import Structure.Transform;
import Enum.Rotation;

public class Player extends GameObject {

    public Player(Enum.Tag tag, Sprite sprite, Transform transform, Attribute attribute) {
        super(tag, sprite, transform, attribute);
    }

    public Player(int x, int y) {
        this.tag = Tag.player;
        this.sprite = new Sprite(this, {"", });
        this.transform = new Transform(this, x, y, Rotation.down);
        this.attribute = new Attribute(this, , , );
    }
}
