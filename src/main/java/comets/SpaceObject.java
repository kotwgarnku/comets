package comets;

public class SpaceObject {
	private String name;
	private Point3D position;
	private double mass;
	private double radius;

	public SpaceObject(String name, Point3D position, double mass, double radius) {
		this.name = name;
		this.position = position;
		this.mass = mass;
		this.radius = radius;
	}

	public SpaceObject(String name, Point3D position, double mass) {
		this(name, position, mass, 0);
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
