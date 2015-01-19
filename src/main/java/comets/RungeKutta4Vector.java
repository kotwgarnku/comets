package comets;

import javafx.geometry.Point3D;

public class RungeKutta4Vector {
    public static void evaluate(SpaceObject thisObject, double dt, VectorEquation derivative) {
        Point3D thisObjectPos = thisObject.getPosition();
        Point3D thisObjectVelocity = thisObject.getVelocity();

        Point3D acceleration_k1 = derivative.f(thisObjectPos);
        Point3D velocity_k1 = thisObjectVelocity;

        Point3D acceleration_k2 = derivative.f(thisObjectPos.add(velocity_k1.multiply(dt / 2)));
        Point3D velocity_k2 = thisObjectVelocity.add(acceleration_k1.multiply(dt/2));

        Point3D acceleration_k3 = derivative.f(thisObjectPos.add(velocity_k2.multiply(dt / 2)));
        Point3D velocity_k3 = thisObjectVelocity.add(acceleration_k2.multiply(dt / 2));

        Point3D acceleration_k4 = derivative.f(thisObjectPos.add(velocity_k3.multiply(dt)));
        Point3D velocity_k4 = thisObjectVelocity.add(acceleration_k3.multiply(dt));
        
        thisObject.updatePosition((velocity_k1.add(velocity_k2.multiply(2)).add(velocity_k3.multiply(2)).add(velocity_k4)).multiply(dt / 6));
        thisObject.updateVelocity((acceleration_k1.add(acceleration_k2.multiply(2)).add(acceleration_k3.multiply(2)).add(acceleration_k4)).multiply(dt/6));
    }
}
