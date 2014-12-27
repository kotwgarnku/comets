package comets;

import javafx.geometry.Point3D;

public class Gravity implements Force {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;

    @Override
    public Point3D calculateAcceleration(SpaceObject thisObject, SpaceObject otherObject) {
        if (thisObject.getPosition() == otherObject.getPosition())
            return Point3D.ZERO;
        Point3D accelerationVector = otherObject.getPosition().subtract(thisObject.getPosition());
        double distance = accelerationVector.magnitude();
        return accelerationVector.multiply(otherObject.getMass()/Math.pow(distance, 3));
    }
}
