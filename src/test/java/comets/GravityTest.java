package comets;

import javafx.geometry.Point3D;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class GravityTest {

    public static final double GRAVITATIONAL_CONSTANT = 6.67384e-11;

    @Test
    public void calculatesCorrectAcceleration() throws Exception {
        SpaceObject movingObject = new SpaceObject("moving object", new Point3D(1, 19, 10), 456);
        SpaceObject standingObject = new SpaceObject("standing object", new Point3D(11, 7, 32), 100);
        Force gravitationalForce = new Gravity();

        Point3D actualAcceleration = gravitationalForce.calculateAcceleration(movingObject, standingObject);
        Point3D expectedAcceleration = new Point3D(1, -25/36f, 25/121f).multiply(GRAVITATIONAL_CONSTANT);

        // TODO: extend JUNIT to support assertions for Point3D
        assertThat(actualAcceleration.getX()).isCloseTo(expectedAcceleration.getX(), within(1E-17));
        assertThat(actualAcceleration.getY()).isCloseTo(expectedAcceleration.getY(), within(1E-17));
        assertThat(actualAcceleration.getZ()).isCloseTo(expectedAcceleration.getZ(), within(1E-17));
    }
}
