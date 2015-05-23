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

        for (SpaceObject object : spaceObjects) {
            kineticEnergy += getKineticEnergy(object);

            List<SpaceObject> spaceObjectsWithoutExamined = new ArrayList<>(spaceObjects);
            spaceObjectsWithoutExamined.remove(object);

            for (SpaceObject anotherObject : spaceObjectsWithoutExamined) {
                potentialEnergy -= getPotentialEnergy(object, anotherObject);
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
        return firstObject.getMass() * secondObject.getMass() / firstObject.getPosition().distance(secondObject.getPosition());
    }
}
