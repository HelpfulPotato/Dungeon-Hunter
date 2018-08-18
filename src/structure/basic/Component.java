package structure.basic;

abstract public class Component {
    protected GameObject parent;

    protected void bind(GameObject parent) {
        this.parent = parent;
    }

    public GameObject getParent() {
        return parent;
    }
}
