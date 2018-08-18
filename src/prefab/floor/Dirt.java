package prefab.floor;

import structure.basic.Transform;
import structure.object.Floor;

public class Dirt extends Floor {
    public Dirt(Transform transform) {
        super(new String[]{"../../pic/floor/dirt.png"}, transform);
    }
}
