package comets;

import javafx.geometry.Point3D;

public interface Equation {
    public Point3D f(State state, double t);
}
