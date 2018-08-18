package prefab.wall;

import structure.basic.Transform;
import structure.object.Wall;

public class Stone extends Wall {
    public Stone(Transform transform) {
        super(new String[]{"../../pic/wall/stone.png"}, transform);
    }
}
