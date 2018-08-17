package structure.object;

import structure.basic.Attribute;
import structure.basic.GameObject;
import structure.basic.Transform;
import enums.Tag;

abstract public class Item extends GameObject {

    public Item(String[] imagePaths, Transform transform, Attribute attribute) {
        super(Tag.item, imagePaths, transform, attribute);
    }

    abstract public String getDescription();
}
