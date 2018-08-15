package Structure.Object;

import Structure.Attribute;
import Structure.GameObject;
import Structure.Sprite;
import Structure.Transform;
import Enum.Tag;
import Enum.Rotation;

public class Wall extends GameObject {


    public Wall(int x, int y) {
        this.tag = Tag.player;
        this.sprite = new Sprite(this, {"", });
        this.transform = new Transform(this, x, y, Rotation.down);
        this.attribute = new Attribute(this, , , );
    }
}
