package comets;

import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.util.Arrays;

public class Update {
    SpaceObject planeta = new SpaceObject("planeta", new Point3D(0,0,0), 5.9736e24);
    SpaceObject planeta2 = new SpaceObject("planeta2", new Point3D(0,300000,0), 5.9736e24);
    ArrayList<SpaceObject> spaceObjects = new ArrayList(Arrays.asList(planeta, planeta2));

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
    public void calculateVelocity(SpaceObject movingObject, double dtime, double time) {
        VelocityFunction velFunction = new VelocityFunction();

        for (double t = 0; t < time; t += dtime) {
            System.out.println("t: " + t);
            System.out.println("v: " + movingObject.getVelocity());
//            System.out.println(movingObject.getPosition().getX() + "\t" + movingObject.getPosition().getY());
            RungeKutta4Vector.evaluate(movingObject, dtime, velFunction);
        }
    }
}
