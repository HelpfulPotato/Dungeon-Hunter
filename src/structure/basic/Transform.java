package structure.basic;

import enums.Rotation;

public class Transform extends Component {

    private int x;
    private int y;
    private Rotation rotation;

    public Transform(int x, int y, Rotation rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
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