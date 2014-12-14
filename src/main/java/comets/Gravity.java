package comets;

public class Gravity {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;

    public static double calculateForce(SpaceObject a, SpaceObject b) {

        double distance = a.getPosition().distance(b.getPosition());
        return GRAVITATIONAL_CONSTANT * a.getMass() * b.getMass() / (distance*distance);
    }
}
