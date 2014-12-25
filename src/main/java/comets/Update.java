package comets;

import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.util.Arrays;

public class Update {
    SpaceObject kometa = new SpaceObject("kometa", new Point3D(0,3.84e8,0), 7.349e22);
    SpaceObject planeta = new SpaceObject("planeta", new Point3D(0,0,0), 5.9736e24);
    ArrayList<SpaceObject> spaceObjects = new ArrayList(Arrays.asList(planeta));


    private class VelocityFunction implements VectorEquation {

        public Point3D f(double x, Point3D y) {
            Point3D outcome = new Point3D(0,0,0);
            for(int i = 0; i < spaceObjects.size(); i++) {
                outcome = outcome.add(Gravity.determineForceVector(kometa, spaceObjects.get(i)));
            }
            //System.out.println("Force: " +outcome.multiply(Gravity.GRAVITATIONAL_CONSTANT*kometa.getMass()));
            return outcome.multiply(Gravity.GRAVITATIONAL_CONSTANT);
        }
    }
    public void calculateVelocity() {
        VelocityFunction velFunction = new VelocityFunction();
        //v0
        Point3D v = new Point3D(0,0,0);

        double dt = 0.5;
        for (double t = 0; t < 10; t += dt) {
            v = RungeKutta4Vector.evaluate(t, v, dt, velFunction);
            System.out.println("v: " + v.toString());
            //System.out.println("dx: " + v.multiply(t));
            kometa.updatePosition(v.multiply(t));
            System.out.println("pos: " + kometa.getPosition().toString());
        }
    }
}
