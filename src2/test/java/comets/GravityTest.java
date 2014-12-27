package comets;

import javafx.geometry.Point3D;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GravityTest {

    @Test
    public void calculatesCorrectResultForForce() throws Exception {
        SpaceObject a = new SpaceObject("kometa", new Point3D(1,19,10), 456);
        SpaceObject b = new SpaceObject("planeta", new Point3D(11,7,32), 789);

        Point3D ForceVector = Gravity.determineForceVector(a, b);
        double distance = Math.sqrt(10*10+12*12+22*22);
        Point3D CorrectVector = new Point3D(10, -12, 22).multiply(b.getMass()/Math.pow(distance, 3));
        assertThat(CorrectVector).isEqualTo(ForceVector);
    }
}