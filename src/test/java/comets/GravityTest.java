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
    }
}
