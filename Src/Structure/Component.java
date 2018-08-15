package Structure;

abstract public class Component {
    protected GameObject parent;

    public Component(GameObject parent) {
        this.parent = parent;
    }
}
