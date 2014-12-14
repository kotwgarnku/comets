/**
* @author  Filip Konieczny, Paweł Koniarski
*/
package comets;

public class SpaceObject {
	String name;
	float mass;
	float radius;
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

	public DefinePosition(Point3D point) {
		this.position = point;
	}
}