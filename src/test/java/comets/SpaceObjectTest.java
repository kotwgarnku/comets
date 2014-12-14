package comets;

import javafx.geometry.Point3D;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpaceObjectTest {

    public static final String NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS = "Space object without radius";
    public static final String NAME_OF_SPACE_OBJECT_WITH_RADIUS = "Space object with radius";
    public static final double MASS = 10.3;
    public static final double RADIUS = 15.4;
    public static final Point3D POSITION = new Point3D(8.4, 10.2, 4.2);
    private SpaceObject spaceObjectWithoutRadius;
    private SpaceObject spaceObjectWithRadius;

    @Before
    public void setUp() throws Exception {
        spaceObjectWithoutRadius = new SpaceObject(NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS, POSITION, MASS);
        spaceObjectWithRadius = new SpaceObject(NAME_OF_SPACE_OBJECT_WITH_RADIUS, POSITION, MASS, RADIUS);
    }

    @Test
    public void returnsCorrectName() throws Exception {
        String nameOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getName();
        String nameOfSpaceObjectWithRadius = spaceObjectWithRadius.getName();

        assertThat(nameOfSpaceObjectWithoutRadius).isEqualTo(NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS);
        assertThat(nameOfSpaceObjectWithRadius).isEqualTo(NAME_OF_SPACE_OBJECT_WITH_RADIUS);
    }

    @Test
    public void returnsCorrectMass() throws Exception {
        double massOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getMass();
        double massOfSpaceObjectWithRadius = spaceObjectWithRadius.getMass();

        assertThat(massOfSpaceObjectWithoutRadius).isEqualTo(MASS);
        assertThat(massOfSpaceObjectWithRadius).isEqualTo(MASS);
    }

    @Test
    public void returnsCorrectPosition() throws Exception {
        Point3D positionOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getPosition();
        Point3D positionOfSpaceObjectWithRadius = spaceObjectWithRadius.getPosition();

        assertThat(positionOfSpaceObjectWithoutRadius).isEqualTo(POSITION);
        assertThat(positionOfSpaceObjectWithRadius).isEqualTo(POSITION);
    }

    @Test
    public void setsPosition() throws Exception {
        Point3D newPosition = new Point3D(6.4, 23.5, -2.5);

        spaceObjectWithoutRadius.setPosition(newPosition);
        Point3D actualPosition = spaceObjectWithoutRadius.getPosition();

        assertThat(actualPosition).isEqualTo(newPosition);
    }

    @Test
    public void returnsRadius() throws Exception {
        double radiusOfSpaceObjectWithRadius = spaceObjectWithRadius.getRadius();

        assertThat(radiusOfSpaceObjectWithRadius).isEqualTo(radiusOfSpaceObjectWithRadius);
    }
}
