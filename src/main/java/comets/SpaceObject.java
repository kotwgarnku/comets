package comets;

import javafx.geometry.Point3D;

public class SpaceObject {
	private String name;
	private Point3D position;
	private Point3D velocity;
	private double mass;
	private double radius;

	public SpaceObject(String name, Point3D position, double mass, double radius) {
		this.name = name;
		this.position = position;
		this.velocity = Point3D.ZERO;
		this.mass = mass;
		this.radius = radius;
	}

	// Point particle
	public SpaceObject(String name, Point3D position, double mass) {
		this(name, position, mass, 0);
	}

	public String getName() {
		return name;
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

	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}
}
