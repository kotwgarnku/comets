package comets;

import javafx.geometry.Point3D;

public class Gravity {

    public static final double GRAVITATIONAL_CONSTANT = 1.42128e-11; //au^3 * 1e-23 kg * day^-2
    public static final double MAX_GRAVITY_RANGE = 50; //au

    public static Point3D calculateForce(SpaceObject someObject, SpaceObject otherObject) {
        if (someObject.getPosition() == otherObject.getPosition())
            return Point3D.ZERO;
        Point3D forceVector = otherObject.getPosition().subtract(someObject.getPosition());
        double distance = forceVector.magnitude();
        if (distance > MAX_GRAVITY_RANGE)
            return Point3D.ZERO;
        return forceVector.multiply(otherObject.getMass() / Math.pow(distance, 3));
    }
}
