package comets;

import javafx.geometry.Point3D;

public class State {
    private Point3D position;
    private Point3D velocity;

    public State() {
        this(Point3D.ZERO);
    }

    public State(Point3D position) {
        this(position, Point3D.ZERO);
    }

    public State(Point3D position, Point3D velocity) {
        this.position = position;
        this.velocity = velocity;
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

    public void setVelocity(Point3D newVelocity) {
        velocity = newVelocity;
    }

    public void updateVelocity(Point3D velocityChange) {
        velocity = velocity.add(velocityChange);
    }

    public Point3D getVelocity() {
        return velocity;
    }

}
