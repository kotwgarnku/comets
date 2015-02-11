package comets;

import javafx.geometry.Point3D;

public class SpaceObject extends State {
	private String name;
	private double mass;
	private double radius;

	public SpaceObject(String name, Point3D position, double mass, double radius) {
		super(position, Point3D.ZERO);
		this.name = name;
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

	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}
}
