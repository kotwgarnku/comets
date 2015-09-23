package comets;

import javafx.geometry.Point3D;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static comets.Gravity.calculateForce;
import static comets.Point3DAssert.assertThat;
import static org.assertj.core.api.Assertions.within;

@RunWith(JUnitParamsRunner.class)
public class GravityTest {

    public static final double MAX_GRAVITY_RANGE = 50;
    public static final int MASS = 100;

    @Test
    @Parameters({"-10, 0, 0, 100, 0, 0, 0",
                 "-10, -10, -10, 19.245, 19.245, 19.245, 1E-5"})
    public void calculatesCorrectForce(double x, double y, double z, double rx, double ry, double rz, double withinValue) throws Exception {
        SpaceObject objectActingForce = new SpaceObject("planet1", new Point3D(0, 0, 0), 100);
        SpaceObject objectActedByForce = new SpaceObject("planet2", new Point3D(x, y, z), MASS);

        Point3D actualForce = calculateForce(objectActedByForce, objectActingForce);
        Point3D expectedForce = new Point3D(rx, ry, rz);

        assertThat(actualForce).isCloseTo(expectedForce, within(withinValue));
    }

    @Test
    public void returnsZeroAccelerationForSamePoints() throws Exception {
        Point3D point = new Point3D(892.23, -785.2, 184);
        SpaceObject object1 = new SpaceObject("planet1", point, MASS);
        SpaceObject object2 = new SpaceObject("planet2", point, MASS);

        Point3D actualAcceleration = calculateForce(object1, object2);
        Point3D expectedAcceleration = Point3D.ZERO;

        assertThat(actualAcceleration).isEqualTo(expectedAcceleration);
    }

    @Test
    public void returnsZeroAccelerationForDistantPoints() throws Exception {
        SpaceObject object1 = new SpaceObject("planet1", Point3D.ZERO, MASS);
        Point3D distantPoint = new Point3D(MAX_GRAVITY_RANGE+1, 0, 0);
        SpaceObject object2 = new SpaceObject("planet2", distantPoint, MASS);

        Point3D actualAcceleration = calculateForce(object1, object2);
        Point3D expectedAcceleration = Point3D.ZERO;

        assertThat(actualAcceleration).isEqualTo(expectedAcceleration);
    }
}
