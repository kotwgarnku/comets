package comets;

import javafx.geometry.Point3D;

public class Gravity {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;
    public static final double MAX_GRAVITY_RANGE = 5e25;

    public static Point3D calculateForce(SpaceObject someObject, SpaceObject otherObject) {
        if(someObject.getPosition() == otherObject.getPosition())
            return Point3D.ZERO;
        Point3D accelerationVector = otherObject.getPosition().subtract(someObject.getPosition());
        double distance = accelerationVector.magnitude();
        if (distance > MAX_GRAVITY_RANGE)
            return Point3D.ZERO;
        return accelerationVector.multiply(otherObject.getMass() / Math.pow(distance, 3));
    }
}
