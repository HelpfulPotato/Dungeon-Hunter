package Structure.Object;

import Structure.Basic.Attribute;
import Structure.Basic.GameObject;
import Structure.Basic.Transform;
import Enum.Tag;

abstract public class Item extends GameObject {

    public Item(String[] imagePaths, Transform transform, Attribute attribute) {
        super(Tag.item, imagePaths, transform, attribute);
    }

    abstract public String getDescription();
}
