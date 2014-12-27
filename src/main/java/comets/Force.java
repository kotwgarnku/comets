package comets;

import javafx.geometry.Point3D;

public interface Force {
    public Point3D calculateAcceleration(SpaceObject movingObject, SpaceObject standingObject);
}
