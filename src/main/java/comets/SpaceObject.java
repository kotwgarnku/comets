package comets;

import javafx.geometry.Point3D;

public class SpaceObject extends State {
	private String name;
	private double mass; //1 unit = 1e23 kg
	private double radius;

	public SpaceObject(String name, Point3D position, double mass, double radius) {
		super(position);
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

	public String toString() {
		return String.format("SpaceObject [name='%s', position=(%s), velocity=(%s), mass=%s, radius=%s]", name, getPosition(), getVelocity(), mass, radius);
	}

    public void divideForceByMass() {
        setForce(getForce().multiply(1 / mass));
    }
}
