package comets;

import javafx.geometry.Point3D;

// derivative of y with respect to x (in three-dimensional coordinate system)
public class RungeKutta4Vector {
    public static Point3D evaluate(double x, Point3D y, double dx, VectorEquation derivative) {
        Point3D k1 = derivative.f(x, y).multiply(dx);
        Point3D k2 = derivative.f(x + dx * 0.5, y.add(k1.multiply(0.5))).multiply(dx);
        Point3D k3 = derivative.f(x + dx * 0.5, y.add(k2.multiply(0.5))).multiply(dx);
        Point3D k4 = derivative.f(x + dx, y.add(k3)).multiply(dx);

        return k1.add(k2.multiply(2)).add(k3.multiply(2)).add(k4).multiply(1/6.0).add(y);
    }
}
