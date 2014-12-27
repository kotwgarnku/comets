package comets;

import javafx.geometry.Point3D;

public class Gravity implements Force {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;

    @Override
    public Point3D calculateAcceleration(SpaceObject movingObject, SpaceObject standingObject) {
        Point3D differenceVector = standingObject.getPosition().subtract(movingObject.getPosition());
        // TODO: change the code to be more 'vector friendly' (only if it won't make the code less clear)
        double x = differenceVector.getX();
        double y = differenceVector.getY();
        double z = differenceVector.getZ();
        x = x != 0 ? Math.signum(x) / (x*x) : 0;
        y = y != 0 ? Math.signum(y) / (y*y) : 0;
        z = z != 0 ? Math.signum(z) / (z*z) : 0;
        return (new Point3D(x, y, z)).multiply(GRAVITATIONAL_CONSTANT * standingObject.getMass());
    }
}
