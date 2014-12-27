package comets;

import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.util.Arrays;

public class Update {
    SpaceObject planeta = new SpaceObject("planeta", new Point3D(0,0,0), 5.9736e24);
    ArrayList<SpaceObject> spaceObjects = new ArrayList(Arrays.asList(planeta));

    private class VelocityFunction implements VectorEquation {
        Force gravityForce = new Gravity();

        public Point3D f(Point3D thisObjectPos) {
            Point3D outcome = Point3D.ZERO;
            for(SpaceObject otherObject : spaceObjects)
                outcome = outcome.add(gravityForce.calculateAcceleration(thisObjectPos, otherObject.getPosition(), otherObject.getMass()));
            //System.out.println("Force: " +outcome.multiply(Gravity.GRAVITATIONAL_CONSTANT*thisObject.getMass()));
            return outcome.multiply(Gravity.GRAVITATIONAL_CONSTANT);
        }
    }
    public void calculateVelocity(SpaceObject movingObject) {
        VelocityFunction velFunction = new VelocityFunction();

        double dt = 1;
        for (double t = 0; t < 400; t += dt) {
            System.out.println("v: " + movingObject.getVelocity());
            System.out.println("pos: " + movingObject.getPosition());
            RungeKutta4Vector.evaluate(movingObject, dt, velFunction);
        }
    }
}
