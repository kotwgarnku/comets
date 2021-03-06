package comets;

import javafx.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

import static comets.Gravity.calculateForce;

public class World {
    private List<SpaceObject> spaceObjects = new ArrayList<>();
    private double time = 0;

    public List<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    public void addSpaceObject(SpaceObject object) {
        spaceObjects.add(object);
    }

    public void addSpaceObjects(List<SpaceObject> objects) {
        spaceObjects.addAll(objects);
    }

    public double getTime() {
        return time;
    }

    public void increaseTime(double timeStep) {
        time += timeStep;
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
        spaceObjects.forEach((object) -> object.setForce(Point3D.ZERO));

        for (int i = 0; i < spaceObjects.size(); i++) {
            for (int j = i+1; j < spaceObjects.size(); j++) {
                setForcesBetweenTwoObjects(spaceObjects.get(i), spaceObjects.get(j));
            }
        }

        spaceObjects.forEach(SpaceObject::multiplyForceByGravitationalConstant);
        spaceObjects.forEach(SpaceObject::divideForceByMass);
    }

    private void setForcesBetweenTwoObjects(SpaceObject first, SpaceObject second) {
        Point3D force = calculateForce(first, second);

        first.setForce(first.getForce().add(force));
        second.setForce(second.getForce().subtract(force));
    }
}
