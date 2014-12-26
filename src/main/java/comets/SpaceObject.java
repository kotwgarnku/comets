package comets;

import javafx.geometry.Point3D;

public class SpaceObject {
	private String name;
	private Point3D position;
	private Point3D velocity;
	private double mass;
	private double radius;
	//object
	public SpaceObject(String name, Point3D position, Point3D velocity, double mass, double radius) {
		this.name = name;
		this.position = position;
		this.velocity = velocity;
		this.mass = mass;
		this.radius = radius;
	}
	//object at rest
	public SpaceObject(String name, Point3D position, double mass, double radius) {
		this(name, position, new Point3D(0,0,0), mass, radius);
	}
	//material point (radius = 0)
	public SpaceObject(String name, Point3D position, Point3D velocity, double mass) {
		this(name, position, velocity, mass, 0);
	}
	//material point at rest
	public SpaceObject(String name, Point3D position, double mass) {
		this(name, position, new Point3D(0,0,0), mass, 0);
	}

	public String getName() {
		return name;
	}

	public void setPosition(Point3D point) {
		position = point;
	}

	public void updatePosition(Point3D point) {
		position = position.add(point);
	}

	public Point3D getPosition() {
		return position;
	}

	public void setVelocity(Point3D velocity) { this.velocity = velocity; }

	public void updateVelocity(Point3D dvelocity) { this.velocity = this.velocity.add(dvelocity); }

	public Point3D getVelocity() { return velocity; }

	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}
}
