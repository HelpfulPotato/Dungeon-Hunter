package structure.object;

import prefab.Player;
import structure.basic.Attribute;
import structure.basic.GameObject;
import enums.Tag;
import structure.basic.Transform;

abstract public class Item extends GameObject {

    public Item(String[] imagePaths, Transform transform, Attribute attribute) {
        super(Tag.item, imagePaths, transform, attribute);
    }

    abstract public String getDescription();

    abstract public void takeEffect(Player player);
}
