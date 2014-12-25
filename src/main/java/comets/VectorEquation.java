package comets;

import javafx.geometry.Point3D;

public interface VectorEquation {
    public Point3D f(double t, Point3D y);
}
