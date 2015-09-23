package comets;

import javafx.geometry.Point3D;

public class Gravity {

    public static final double GRAVITATIONAL_CONSTANT = 8.8877245E-10; //au^3 * Earth's mass * day^-2
    public static final double MAX_GRAVITY_RANGE = 50; //au

    public static Point3D calculateForce(SpaceObject someObject, SpaceObject otherObject) {
        if (someObject.getPosition().equals(otherObject.getPosition()))
            return Point3D.ZERO;
        Point3D forceVector = otherObject.getPosition().subtract(someObject.getPosition());
        double distance = forceVector.magnitude();
        if (distance > MAX_GRAVITY_RANGE)
            return Point3D.ZERO;
        return forceVector.multiply(someObject.getMass() * otherObject.getMass() / Math.pow(distance, 3));
    }
}
