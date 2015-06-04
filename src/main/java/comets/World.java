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

    public double getEnergy() {
        double kineticEnergy = 0;
        double potentialEnergy = 0;

        for (int i = 0; i < spaceObjects.size(); i++) {
            kineticEnergy += getKineticEnergy(spaceObjects.get(i));

            for (int j = i+1; j < spaceObjects.size(); j++) {
                potentialEnergy += getPotentialEnergy(spaceObjects.get(i), spaceObjects.get(j));
            }
        }
        potentialEnergy *= Gravity.GRAVITATIONAL_CONSTANT;
        return kineticEnergy + potentialEnergy;
    }

    private double getKineticEnergy(SpaceObject object) {
        double velocity = object.getVelocity().magnitude();
        return object.getMass() * velocity * velocity * 0.5;
    }

    private double getPotentialEnergy(SpaceObject firstObject, SpaceObject secondObject) {
        return -firstObject.getMass() * secondObject.getMass() / firstObject.getPosition().distance(secondObject.getPosition());
    }
}
