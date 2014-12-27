package comets;

import javafx.geometry.Point3D;

public class Gravity implements Force {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;

    @Override
    public Point3D calculateAcceleration(SpaceObject movingObject, SpaceObject standingObject) {
        Point3D differenceVector = standingObject.getPosition().subtract(movingObject.getPosition());
        double x = differenceVector.getX();
        double y = differenceVector.getY();
        double z = differenceVector.getZ();
        Point3D acceleration = new Point3D(Math.signum(x) / (x*x), Math.signum(y) / (y*y), Math.signum(z) / (z*z));
        return acceleration.multiply(GRAVITATIONAL_CONSTANT * standingObject.getMass());
    }
}
