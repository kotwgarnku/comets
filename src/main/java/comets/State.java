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
        position = newPosition;
    }

    public void updatePosition(Point3D positionChange) {
        position = position.add(positionChange);
    }

    public Point3D getPosition() {
        return position;
    }

    public void setPreviousPosition(Point3D newPreviousPosition) {
        previousPosition = newPreviousPosition;
    }

    public Point3D getPreviousPosition() {
        return previousPosition;
    }

    public void setVelocity(Point3D newVelocity) {
        velocity = newVelocity;
    }

    public void updateVelocity(Point3D velocityChange) {
        velocity = velocity.add(velocityChange);
    }

    public Point3D getVelocity() {
        return velocity;
    }

    public void setPreviousVelocity(Point3D newPreviousVelocity) {
        previousVelocity = newPreviousVelocity;
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
}
