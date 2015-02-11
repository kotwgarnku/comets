package comets;

import javafx.geometry.Point3D;

public class Derivative {
    public Point3D dxdt;
    public Point3D dvdt;

    public Derivative() {
        dxdt = Point3D.ZERO;
        dvdt = Point3D.ZERO;
    }
}
