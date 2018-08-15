package Structure;

import Enum.Tag;

abstract public class GameObject implements Drawable{

    protected Tag tag;
    protected Sprite sprite;
    protected Transform transform;
    protected Attribute attribute;

    public GameObject(Tag tag, String[] imagePaths, int x, int y) {
        this.tag = tag;
        this.sprite = new Sprite(this, {"", });
        this.transform = new Transform(this, x, y, Rotation.down);
        this.attribute = new Attribute(this, , , );
    }

    @Override
	public void paint() {

		// a null transform means this object is in inventory.
		if (transform != null) {

		} else return;
	}

    public Tag getTag() {
        return tag;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Transform getTransform() {
        return transform;
    }

    public Attribute getAttribute() {
        return attribute;
    }
}
