package comets;

import javafx.geometry.Point3D;


public class SpaceObject {
	String name;
	double mass;
	double radius;
	Point3D position;

	public SpaceObject(String name, float mass) {
		//material point
		this.name = name;
		this.mass = mass;
	}

	public SpaceObject(String name, float mass, float radius) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
	}

	public void DefinePosition(Point3D point) {
		this.position = point;
	}

	public Point3D getPosition() { return this.position; }
	public double getMass() { return this.mass; }
}