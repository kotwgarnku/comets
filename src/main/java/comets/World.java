package comets;

import javafx.geometry.Point3D;

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

    public void addSpaceObjects(List<SpaceObject> spaceObjects) {
        spaceObjects.forEach(this::addSpaceObject);
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

    public void calculateForces() {
        int worldSize = getSpaceObjects().size();
        //set every force acting on object to 0
        getSpaceObjects().forEach((object) -> object.setForce(Point3D.ZERO));
        //set forces between objects (vectors)
        for(int i = 0; i < worldSize; i++) {
            for(int j = i+1; j < worldSize; j++) {
                SpaceObject object = getSpaceObjects().get(i);
                SpaceObject otherObject = getSpaceObjects().get(j);

                Point3D force = Gravity.calculateForce(object, otherObject);

                object.setForce(object.getForce().add(force));
                otherObject.setForce(otherObject.getForce().subtract(force));
            }
        }
        //multiply forces by gravitational constant
        for(int i = 0; i < worldSize; i++) {
            SpaceObject object = getSpaceObjects().get(i);
            object.setForce(object.getForce().multiply(Gravity.GRAVITATIONAL_CONSTANT));
        }
    }
}
