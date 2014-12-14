package comets;

import javafx.geometry.Point3D;


public class SpaceObject {
	private String name;
	private double mass;
	private double radius;
	private Point3D position;

	public SpaceObject(String name, double mass, Point3D position) {
		this.name = name;
		this.mass = mass;
		this.position = position;
	}

	public SpaceObject(String name, double mass, double radius, Point3D position) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setPosition(Point3D point) {
		position = point;
	}

	public Point3D getPosition() {
		return position;
	}

	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}
}
