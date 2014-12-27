package comets;

import javafx.geometry.Point3D;

public class Gravity implements Force {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;
    public final static double MAX_GRAVITY_RANGE = 5e15;

    @Override
    public Point3D calculateAcceleration(Point3D thisObjectPos, Point3D otherObjectPos, double otherObjectMass) {
        if (thisObjectPos == otherObjectPos)
            return Point3D.ZERO;
        Point3D accelerationVector = otherObjectPos.subtract(thisObjectPos);
        double distance = accelerationVector.magnitude();
        if (distance > MAX_GRAVITY_RANGE)
            return Point3D.ZERO;
        return accelerationVector.multiply(otherObjectMass/Math.pow(distance, 3));
    }
}
