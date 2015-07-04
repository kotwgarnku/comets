package comets;

import javafx.geometry.Point3D;

public class State {
    private Point3D position;
    private Point3D previousPosition;
    private Point3D velocity;
    private Point3D previousVelocity;
    private Point3D force;

    public State() {
        this(Point3D.ZERO);
    }

    public State(Point3D position) {
        this(position, Point3D.ZERO);
    }

    public State(Point3D position, Point3D velocity) {
        this.position = position;
        previousPosition = Point3D.ZERO;
        this.velocity = velocity;
        previousVelocity = Point3D.ZERO;
        force = Point3D.ZERO;
    }

    public void setPosition(Point3D newPosition) {
        previousPosition = position;
        position = newPosition;
    }

    public void updatePosition(Point3D positionChange) {
        setPosition(position.add(positionChange));
    }

    public Point3D getPosition() {
        return position;
    }

    public Point3D getPreviousPosition() {
        return previousPosition;
    }

    public void setVelocity(Point3D newVelocity) {
        previousVelocity = velocity;
        velocity = newVelocity;
    }

    public void updateVelocity(Point3D velocityChange) {
        setVelocity(velocity.add(velocityChange));
    }

    public Point3D getVelocity() {
        return velocity;
    }

    public Point3D getPreviousVelocity() {
        return previousVelocity;
    }

    public void setForce(Point3D newForce) {
        force = newForce;
    }

    public Point3D getForce() {
        return force;
    }

    public void multiplyForceByGravitationalConstant() {
        force = force.multiply(Gravity.GRAVITATIONAL_CONSTANT);
    }

    public void doSimulationStep(double time, double timeStep) {
        RungeKutta4 rk4 = new RungeKutta4(((state, t) -> state.getForce()));
        rk4.evaluate(this, time, timeStep);
    }
}
