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
		//punkt materialny
		this.name = name;
		this.mass = mass;
	}

	public SpaceObject(String name, float mass, float radius) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
	}

}