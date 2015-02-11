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
            //System.out.println("Force: " +outcome.multiply(Gravity.GRAVITATIONAL_CONSTANT*comet.getMass()));
            return outcome.multiply(Gravity.GRAVITATIONAL_CONSTANT);
        }
    }
    public void calculateVelocity() {
        VelocityFunction velFunction = new VelocityFunction();
        RungeKutta4 rk4 = new RungeKutta4(velFunction);
        comet.setVelocity(new Point3D(1023.47, 0, 0));
        //System.out.println("Start");
        double dt = 100;
        for (double t = 0; t < 2332800; t += dt) {
            rk4.evaluate(comet, t, dt);
            Point3D pos = comet.getPosition();
            Point3D vel = comet.getPosition();
            //System.out.println(pos.getX() + "\t" + pos.getY());
//            if (t == 1000) {
//                System.out.println("v: " + vel);
//                System.out.println("pos: " + pos);
//            }
        }
    }
}
