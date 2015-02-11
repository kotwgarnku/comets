package comets;

import javafx.geometry.Point3D;

public class Gravity implements Force {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;
    public static final double MAX_GRAVITY_RANGE = 5e15;

    @Override
    public Point3D calculateAcceleration(Point3D thisObject, Point3D otherObject, double otherObjectsMass) {
        if (thisObject.equals(otherObject))
            return Point3D.ZERO;
        Point3D accelerationVector = otherObject.subtract(thisObject);
        double distance = accelerationVector.magnitude();
        if (distance > MAX_GRAVITY_RANGE)
            return Point3D.ZERO;
        return accelerationVector.multiply(otherObjectsMass / Math.pow(distance, 3));
    }
}
