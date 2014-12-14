package comets;

public class SpaceObject {
	private String name;
	private double mass;
	private double radius;
	private Point3D position;

	public SpaceObject(String name, Point3D position, double mass) {
		this.name = name;
		this.mass = mass;
		this.position = position;
		radius = 0;
	}

	public SpaceObject(String name, Point3D position, double mass, double radius) {
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
