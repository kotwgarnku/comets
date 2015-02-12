package comets;

import java.util.ArrayList;

public class World {
    private ArrayList<SpaceObject> spaceObjects = new ArrayList<>();

    public World(ArrayList<SpaceObject> spaceObjects) {
        this.spaceObjects = spaceObjects;
    }

    public ArrayList<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    public void addSpaceObject(SpaceObject someObject) {
        spaceObjects.add(someObject);
    }
}
