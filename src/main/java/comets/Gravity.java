package comets;

public class Gravity {

    public static double gravitational_constant = 6.67384e-11;

    public static double calculateForce(SpaceObject a, SpaceObject b) {

        double distance = a.getPosition().distance(b.getPosition());
        return gravitational_constant * a.getMass() * b.getMass() / (distance*distance);

    }
}
