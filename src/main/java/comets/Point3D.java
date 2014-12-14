package comets;

public class Point3D extends javafx.geometry.Point3D {

    public Point3D(double x, double y, double z) {
        super(x, y, z);
    }

    public Point3D subtract(Point3D anotherPoint) {
        double x = this.getX() - anotherPoint.getX();
        double y = this.getY() - anotherPoint.getY();
        double z = this.getZ() - anotherPoint.getZ();

        return new Point3D(x, y, z);
    }
}
