package src.main.java;
/**
 * @author Filip Konieczny, Paweł Koniarski
 */
import java.lang.math.sqrt;
import SpaceObject;

public class Gravity {

    public static double gravitational_constant = 6.67384e-11;

    public static double Force(SpaceObject a, SpaceObject b) {

        double distance = a.getPosition().distance(b.getPosition());
        double force = gravitational_constant * a.getMass() * b.getMass() / (distance*distance);

    }
}
