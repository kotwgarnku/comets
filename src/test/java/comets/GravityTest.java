package comets;

import javafx.geometry.Point3D;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static comets.Point3DAssert.assertThat;
import static org.assertj.core.api.Assertions.within;

@RunWith(JUnitParamsRunner.class)
public class GravityTest {

    public static final double MAX_GRAVITY_RANGE = 5e26;
    public static final int MASS = 100;
    public Gravity gravitationalForce;

    @Before
    public void setUp() throws Exception {
        gravitationalForce = new Gravity();
    }

    @Test
    @Parameters({"-10, 0, 0, 1, 0, 0, 0",
                 "-10, -10, -10, 0.19245, 0.19245, 0.19245, 1E-5"})
    public void calculatesCorrectAcceleration(double x, double y, double z, double rx, double ry, double rz, double withinValue) throws Exception {
        SpaceObject objectActingForce = new SpaceObject("planet1", new Point3D(0, 0, 0), 100);
        SpaceObject objectActedByForce = new SpaceObject("planet2", new Point3D(x, y, z), MASS);

        Point3D actualAcceleration = gravitationalForce.calculateForce(objectActedByForce, objectActingForce);
        Point3D expectedAcceleration = new Point3D(rx, ry, rz);

        assertThat(actualAcceleration).isCloseTo(expectedAcceleration, within(withinValue));
    }

    @Test
    public void returnsZeroAccelerationForSamePoints() throws Exception {
        Point3D point = new Point3D(892.23, -785.2, 184);
        SpaceObject object1 = new SpaceObject("planet1", point, MASS);
        SpaceObject object2 = new SpaceObject("planet2", point, MASS);

        Point3D actualAcceleration = gravitationalForce.calculateForce(object1, object2);
        Point3D expectedAcceleration = Point3D.ZERO;

        assertThat(actualAcceleration).isEqualTo(expectedAcceleration);
    }

    @Test
    public void returnsZeroAccelerationForDistantPoints() throws Exception {
        SpaceObject object1 = new SpaceObject("planet1", Point3D.ZERO, MASS);
        Point3D distantPoint = new Point3D(MAX_GRAVITY_RANGE, 0, 0);
        SpaceObject object2 = new SpaceObject("planet2", distantPoint, MASS);

        Point3D actualAcceleration = gravitationalForce.calculateForce(object1, object2);
        Point3D expectedAcceleration = Point3D.ZERO;

        assertThat(actualAcceleration).isEqualTo(expectedAcceleration);
    }
}
