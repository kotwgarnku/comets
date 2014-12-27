package comets;

import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.util.Arrays;

public class Update {
    SpaceObject kometa = new SpaceObject("kometa", new Point3D(0,3.84e8,0), 7.349e22);
    SpaceObject planeta = new SpaceObject("planeta", new Point3D(0,0,0), 5.9736e24);
    ArrayList<SpaceObject> spaceObjects = new ArrayList(Arrays.asList(planeta));


    private class VelocityFunction implements VectorEquation {

        Force gravitationalForce = new Gravity();

        public Point3D f(double x, Point3D y) {
            Point3D outcome = Point3D.ZERO;
            for(SpaceObject object : spaceObjects)
                outcome = outcome.add(gravitationalForce.calculateAcceleration(kometa, object));
            //System.out.println("Force: " +outcome.multiply(Gravity.GRAVITATIONAL_CONSTANT*kometa.getMass()));
            return outcome;
        }
    }
    public void calculateVelocity() {
        VelocityFunction velFunction = new VelocityFunction();
        //v0
        Point3D v = Point3D.ZERO;

        double dt = 0.5;
        for (double t = 0; t < 10; t += dt) {
            v = RungeKutta4Vector.evaluate(t, v, dt, velFunction);
            System.out.println("v: " + v);
            Point3D changeInPosition = v.multiply(dt);
            //System.out.println("dx: " + changeInPosition);
            kometa.updatePosition(changeInPosition);
            System.out.println("pos: " + kometa.getPosition());
        }
    }
}
