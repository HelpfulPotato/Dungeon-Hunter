package structure.basic;

import enums.Tag;
import enums.Rotation;

import java.util.HashMap;

abstract public class GameObject {
    protected Tag tag;
    protected HashMap<Rotation, Sprite> sprites;
    protected Transform transform;
    protected Attribute attribute;

    public GameObject(Tag tag) {
        this.tag = tag;
    }

    public GameObject(Tag tag, String[] imagePaths, Transform transform) {
        this(tag);
        this.sprites = new HashMap<Rotation, Sprite>();
        this.buildSprite(imagePaths, Rotation.down);
        this.transform = transform;
        this.transform.bind(this);
    }

    public GameObject(Tag tag, Attribute attribute) {
        this(tag);
        this.attribute = attribute;
        this.attribute.bind(this);
    }

    public GameObject(Tag tag, String[] imagePaths, Transform transform, Attribute attribute) {
        this(tag, imagePaths, transform);
        this.attribute = attribute;
        this.attribute.bind(this);
    }

    public GameObject(Tag tag, HashMap<Rotation, String[]> imagePaths, Transform transform, Attribute attribute) {
        this(tag, imagePaths.get(Rotation.down), transform, attribute);
        this.buildSprite(imagePaths.get(Rotation.up), Rotation.up);
        this.buildSprite(imagePaths.get(Rotation.left), Rotation.left);
        this.buildSprite(imagePaths.get(Rotation.down), Rotation.down);
    }

	// function used to prevent duplicate storing of same images
	public void copySprite() {

    }

    public void buildSprite(String[] imagePaths, Rotation rotation) {
        this.sprites.put(rotation, new Sprite(imagePaths));
        this.sprites.get(rotation).bind(this);
    }

    public Tag getTag() {
        return tag;
    }

    public Sprite getSprite() {
        if (sprites.get(transform.getRotation()) == null) {
            throw new NullPointerException("Sprite is null");
        }
        return sprites.get(transform.getRotation());
    }

    public Transform getTransform() {

        if (transform == null) {
            throw new NullPointerException("Transform is null");
        }
        return transform;
    }

    public Attribute getAttribute() {
        if (attribute == null) {
            throw new NullPointerException("Attribute is null");
        }
        return attribute;
    }


}
