package Structure;

import Enum.Rotation;

public class Transform extends Component {

    private int x;
    private int y;
    private Rotation rotation;

    public Transform(GameObject parent, int x, int y, Rotation rotation) {
        super(parent);
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public GameObject getParent() {
        return parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }
}
