package comets;

import javafx.geometry.Point3D;

public class Gravity {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;

    public static Point3D determineForceVector(SpaceObject a, SpaceObject b) {

        double distance = a.getPosition().distance(b.getPosition());
        Point3D ForceVector = b.getPosition().subtract(a.getPosition());
        return ForceVector.multiply(b.getMass()/Math.pow(distance, 3));
    }
}
