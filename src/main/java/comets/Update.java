package comets;

import javafx.geometry.Point3D;

import java.util.ArrayList;
import java.util.Arrays;

public class Update {

    SpaceObject comet = new SpaceObject("comet", new Point3D(0,3.84e8,0), 7.349e22);
    SpaceObject planeta = new SpaceObject("planet", new Point3D(0,0,0), 5.9736e24);
    ArrayList<SpaceObject> spaceObjects = new ArrayList(Arrays.asList(planeta));


    private class VelocityFunction implements Equation {

        Force gravitationalForce = new Gravity();

        public Point3D f(State state, double t) {
            Point3D outcome = Point3D.ZERO;
            for(SpaceObject object : spaceObjects)
                outcome = outcome.add(gravitationalForce.calculateAcceleration(state.getPosition(), object.getPosition(), object.getMass()));

            return outcome.multiply(Gravity.GRAVITATIONAL_CONSTANT);
        }
    }
    public void calculateVelocity(SpaceObject movingObject, double dtime, double time) {
        VelocityFunction velFunction = new VelocityFunction();
        RungeKutta4 rk4 = new RungeKutta4(velFunction);
        double energy;

        for (double t = 0; t < time; t += dtime) {
            rk4.evaluate(movingObject, t, dtime);
            Point3D pos = movingObject.getPosition();
            Point3D vel = movingObject.getPosition();
            energy = Energy.calculateEnergy(spaceObjects);
            System.out.println("t: " + t);
            System.out.println("v: " + movingObject.getVelocity());
            System.out.println("energy: " + energy);
        }
    }
}
