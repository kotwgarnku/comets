package comets;

import javafx.geometry.Point3D;

public interface Force {
    public Point3D calculateAcceleration(Point3D thisObjectPos, Point3D otherObjectPos, double otherObjectMass);
}
