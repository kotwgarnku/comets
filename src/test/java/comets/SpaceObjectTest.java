package comets;

import javafx.geometry.Point3D;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpaceObjectTest {

    public static final String NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS = "Space object without radius";
    public static final String NAME_OF_SPACE_OBJECT_WITH_RADIUS = "Space object with radius";
    public static final Point3D POSITION = new Point3D(8.4, 10.2, 4.2);
    public static final Point3D VELOCITY = new Point3D(9.9, 12.34, -23.6);
    public static final double MASS = 10.3;
    public static final double RADIUS = 15.4;
    private SpaceObject spaceObjectWithoutRadius;
    private SpaceObject spaceObjectWithRadius;

    @Before
    public void setUp() throws Exception {
        spaceObjectWithoutRadius = new SpaceObject(NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS, POSITION, MASS);
        spaceObjectWithoutRadius.setVelocity(VELOCITY);
        spaceObjectWithRadius = new SpaceObject(NAME_OF_SPACE_OBJECT_WITH_RADIUS, POSITION, MASS, RADIUS);
        spaceObjectWithRadius.setVelocity(VELOCITY);
    }

    @Test
    public void returnsCorrectName() throws Exception {
        String nameOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getName();
        String nameOfSpaceObjectWithRadius = spaceObjectWithRadius.getName();

        assertThat(nameOfSpaceObjectWithoutRadius).isEqualTo(NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS);
        assertThat(nameOfSpaceObjectWithRadius).isEqualTo(NAME_OF_SPACE_OBJECT_WITH_RADIUS);
    }

    @Test
    public void updatesPosition() throws Exception {
        Point3D changeInPosition = new Point3D(0.2, -0.8, 2.0);
        Point3D expectedNewPosition = POSITION.add(changeInPosition);

        spaceObjectWithoutRadius.updatePosition(changeInPosition);
        spaceObjectWithRadius.updatePosition(changeInPosition);

        Point3D actualPositionWithoutRadius = spaceObjectWithoutRadius.getPosition();
        Point3D actualPositionWithRadius = spaceObjectWithRadius.getPosition();

        assertThat(actualPositionWithoutRadius).isEqualTo(expectedNewPosition);
        assertThat(actualPositionWithRadius).isEqualTo(expectedNewPosition);
    }

    @Test
    public void returnsCorrectPosition() throws Exception {
        Point3D positionOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getPosition();
        Point3D positionOfSpaceObjectWithRadius = spaceObjectWithRadius.getPosition();

        assertThat(positionOfSpaceObjectWithoutRadius).isEqualTo(POSITION);
        assertThat(positionOfSpaceObjectWithRadius).isEqualTo(POSITION);
    }

    @Test
    public void setsVelocity() throws Exception {
        Point3D newVelocity = new Point3D(3.1, -94.5, 0.08);

        spaceObjectWithoutRadius.setVelocity(newVelocity);
        spaceObjectWithRadius.setVelocity(newVelocity);

        Point3D actualVelocityWithoutRadius = spaceObjectWithoutRadius.getVelocity();
        Point3D actualVelocityWithRadius = spaceObjectWithoutRadius.getVelocity();

        assertThat(actualVelocityWithoutRadius).isEqualTo(newVelocity);
        assertThat(actualVelocityWithRadius).isEqualTo(newVelocity);
    }

    @Test
    public void updatesVelocity() throws Exception {
        Point3D changeInVelocity = new Point3D(-0.6, 2.42, 3.79);
        Point3D expectedNewVelocity = VELOCITY.add(changeInVelocity);

        spaceObjectWithoutRadius.updateVelocity(changeInVelocity);
        spaceObjectWithRadius.updateVelocity(changeInVelocity);

        Point3D actualVelocityWithoutRadius = spaceObjectWithoutRadius.getVelocity();
        Point3D actualVelocityWithRadius = spaceObjectWithRadius.getVelocity();

        assertThat(actualVelocityWithoutRadius).isEqualTo(expectedNewVelocity);
        assertThat(actualVelocityWithRadius).isEqualTo(expectedNewVelocity);
    }

    @Test
    public void returnsCorrectVelocity() throws Exception {
        Point3D velocityOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getVelocity();
        Point3D velocityOfSpaceObjectWithRadius = spaceObjectWithRadius.getVelocity();

        assertThat(velocityOfSpaceObjectWithoutRadius).isEqualTo(VELOCITY);
        assertThat(velocityOfSpaceObjectWithRadius).isEqualTo(VELOCITY);
    }

    @Test
    public void returnsCorrectMass() throws Exception {
        double massOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getMass();
        double massOfSpaceObjectWithRadius = spaceObjectWithRadius.getMass();

        assertThat(massOfSpaceObjectWithoutRadius).isEqualTo(MASS);
        assertThat(massOfSpaceObjectWithRadius).isEqualTo(MASS);
    }

    @Test
    public void returnsCorrectRadius() throws Exception {
        double radiusOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getRadius();
        double radiusOfSpaceObjectWithRadius = spaceObjectWithRadius.getRadius();

        assertThat(radiusOfSpaceObjectWithoutRadius).isEqualTo(0);
        assertThat(radiusOfSpaceObjectWithRadius).isEqualTo(RADIUS);
    }
}
