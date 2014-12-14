package comets;

import javafx.geometry.Point3D;


public class SpaceObject {
	String name;
	double mass;
	double radius;
	Point3D position;

	public SpaceObject(String name, float mass, Point3D position) {
		this.name = name;
		this.mass = mass;
		this.position = position;
	}

	public SpaceObject(String name, float mass, float radius, Point3D position) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		this.position = position;
	}

	public void setPosition(Point3D point) {
		this.position = point;
	}

	public Point3D getPosition() {
		return this.position;
	}

	public double getMass() {
		return this.mass;
	}
}
