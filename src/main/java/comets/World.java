package comets;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<SpaceObject> spaceObjects = new ArrayList<>();

    public List<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    public void addSpaceObject(SpaceObject someObject) {
        spaceObjects.add(someObject);
    }
}
