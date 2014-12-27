package comets;

import javafx.geometry.Point3D;

public class RungeKutta4Vector {
    public static Point3D evaluate(double t, Point3D y, double dt, VectorEquation derivative) {
        Point3D k1 = derivative.f(t, y).multiply(dt);
        Point3D k2 = derivative.f(t + dt * 0.5, y.add(k1.multiply(0.5))).multiply(dt);
        Point3D k3 = derivative.f(t + dt * 0.5, y.add(k2.multiply(0.5))).multiply(dt);
        Point3D k4 = derivative.f(t + dt, y.add(k3)).multiply(dt);

        return y.add((k1.add(k2.multiply(2).add(k3.multiply(2)).add(k4)).multiply(1/6.0)));
    }
}
