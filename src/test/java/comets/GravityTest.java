package comets;

import javafx.geometry.Point3D;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@RunWith(JUnitParamsRunner.class)
public class GravityTest {

    public static final double MAX_GRAVITY_RANGE = 5e15;
    public Gravity gravitationalForce;

    @Before
    public void setUp() throws Exception {
        gravitationalForce = new Gravity();
    }

    @Test
    @Parameters({"-10, 0, 0, 1, 0, 0, 0",
                 "-10, -10, -10, 0.19245, 0.19245, 0.19245, 1E-5"})
    public void calculatesCorrectAcceleration(double x, double y, double z, double rx, double ry, double rz, double withinValue) throws Exception {
        Point3D objectActingForce = new Point3D(0, 0, 0);
        Point3D objectActedByForce = new Point3D(x, y, z);
        double massOfObjectActingForce = 100;

        Point3D actualAcceleration = gravitationalForce.calculateAcceleration(objectActedByForce, objectActingForce, massOfObjectActingForce);
        Point3D expectedAcceleration = new Point3D(rx, ry, rz);

        // TODO: isCloseTo for Point3D
        assertThat(actualAcceleration.getX()).isCloseTo(expectedAcceleration.getX(), within(withinValue));
        assertThat(actualAcceleration.getY()).isCloseTo(expectedAcceleration.getY(), within(withinValue));
        assertThat(actualAcceleration.getZ()).isCloseTo(expectedAcceleration.getZ(), within(withinValue));
    }

    @Test
    public void returnsZeroAccelerationForSamePoints() throws Exception {
        Point3D point1 = new Point3D(892.23, -785.2, 184);
        Point3D point2 = new Point3D(892.23, -785.2, 184);

        Point3D actualAcceleration = gravitationalForce.calculateAcceleration(point1, point2, 100);
        Point3D expectedAcceleration = Point3D.ZERO;

        assertThat(actualAcceleration).isEqualTo(expectedAcceleration);
    }

    @Test
    public void returnsZeroAccelerationForDistantPoints() throws Exception {
        Point3D point1 = Point3D.ZERO;
        Point3D point2 = new Point3D(MAX_GRAVITY_RANGE+1, 0, 0);

        Point3D actualAcceleration = gravitationalForce.calculateAcceleration(point1, point2, 100);
        Point3D expectedAcceleration = Point3D.ZERO;

        assertThat(actualAcceleration).isEqualTo(expectedAcceleration);
    }
}
