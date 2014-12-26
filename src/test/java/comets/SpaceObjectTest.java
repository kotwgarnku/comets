package comets;

import javafx.geometry.Point3D;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpaceObjectTest {

    public static final String NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS = "Space object without radius";
    public static final String NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS_AT_REST = "Space object without radius at rest";
    public static final String NAME_OF_SPACE_OBJECT_WITH_RADIUS = "Space object with radius";
    public static final String NAME_OF_SPACE_OBJECT_WITH_RADIUS_AT_REST = "Space object with radius at rest";
    public static final Point3D POSITION = new Point3D(8.4, 10.2, 4.2);
    public static final Point3D VELOCITY = new Point3D(9.9, 12.34, -23.6);
    public static final double MASS = 10.3;
    public static final double RADIUS = 15.4;
    private SpaceObject spaceObjectWithoutRadius;
    private SpaceObject spaceObjectWithoutRadiusAtRest;
    private SpaceObject spaceObjectWithRadius;
    private SpaceObject spaceObjectWithRadiusAtRest;

    @Before
    public void setUp() throws Exception {
        spaceObjectWithoutRadius = new SpaceObject(NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS, POSITION, VELOCITY, MASS);
        spaceObjectWithoutRadiusAtRest = new SpaceObject(NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS_AT_REST, POSITION, MASS);
        spaceObjectWithRadius = new SpaceObject(NAME_OF_SPACE_OBJECT_WITH_RADIUS, POSITION, VELOCITY, MASS, RADIUS);
        spaceObjectWithRadiusAtRest = new SpaceObject(NAME_OF_SPACE_OBJECT_WITH_RADIUS_AT_REST, POSITION, MASS, RADIUS);
    }

    @Test
    public void returnsCorrectName() throws Exception {
        String nameOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getName();
        String nameOfSpaceObjectWithoutRadiusAtRest = spaceObjectWithoutRadiusAtRest.getName();
        String nameOfSpaceObjectWithRadius = spaceObjectWithRadius.getName();
        String nameOfSpaceObjectWithRadiusAtRest = spaceObjectWithRadiusAtRest.getName();

        assertThat(nameOfSpaceObjectWithoutRadius).isEqualTo(NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS);
        assertThat(nameOfSpaceObjectWithoutRadiusAtRest).isEqualTo(NAME_OF_SPACE_OBJECT_WITHOUT_RADIUS_AT_REST);
        assertThat(nameOfSpaceObjectWithRadius).isEqualTo(NAME_OF_SPACE_OBJECT_WITH_RADIUS);
        assertThat(nameOfSpaceObjectWithRadiusAtRest).isEqualTo(NAME_OF_SPACE_OBJECT_WITH_RADIUS_AT_REST);
    }

    @Test
    public void returnsCorrectPosition() throws Exception {
        Point3D positionOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getPosition();
        Point3D positionOfSpaceObjectWithoutRadiusAtRest = spaceObjectWithoutRadiusAtRest.getPosition();
        Point3D positionOfSpaceObjectWithRadius = spaceObjectWithRadius.getPosition();
        Point3D positionOfSpaceObjectWithRadiusAtRest = spaceObjectWithRadiusAtRest.getPosition();

        assertThat(positionOfSpaceObjectWithoutRadius).isEqualTo(POSITION);
        assertThat(positionOfSpaceObjectWithoutRadiusAtRest).isEqualTo(POSITION);
        assertThat(positionOfSpaceObjectWithRadius).isEqualTo(POSITION);
        assertThat(positionOfSpaceObjectWithRadiusAtRest).isEqualTo(POSITION);
    }

    @Test
    public void setsPosition() throws Exception {
        Point3D newPosition = new Point3D(6.4, 23.5, -2.5);

        spaceObjectWithoutRadius.setPosition(newPosition);
        spaceObjectWithoutRadiusAtRest.setPosition(newPosition);
        spaceObjectWithRadius.setPosition(newPosition);
        spaceObjectWithRadiusAtRest.setPosition(newPosition);

        Point3D actualPositionOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getPosition();
        Point3D actualPositionOfSpaceObjectWithoutRadiusAtRest = spaceObjectWithoutRadiusAtRest.getPosition();
        Point3D actualPositionOfSpaceObjectWithRadius = spaceObjectWithoutRadius.getPosition();
        Point3D actualPositionOfSpaceObjectWithRadiusAtRest = spaceObjectWithoutRadiusAtRest.getPosition();

        assertThat(actualPositionOfSpaceObjectWithoutRadius).isEqualTo(newPosition);
        assertThat(actualPositionOfSpaceObjectWithoutRadiusAtRest).isEqualTo(newPosition);
        assertThat(actualPositionOfSpaceObjectWithRadius).isEqualTo(newPosition);
        assertThat(actualPositionOfSpaceObjectWithRadiusAtRest).isEqualTo(newPosition);
    }

    @Test
    public void returnsCorrectVelocity() throws Exception {
        Point3D velocityOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getVelocity();
        Point3D velocityOfSpaceObjectWithoutRadiusAtRest = spaceObjectWithoutRadiusAtRest.getVelocity();
        Point3D velocityOfSpaceObjectWithRadius = spaceObjectWithRadius.getVelocity();
        Point3D velocityOfSpaceObjectWithRadiusAtRest = spaceObjectWithRadiusAtRest.getVelocity();

        assertThat(velocityOfSpaceObjectWithoutRadius).isEqualTo(VELOCITY);
        assertThat(velocityOfSpaceObjectWithoutRadiusAtRest).isEqualTo(new Point3D(0,0,0));
        assertThat(velocityOfSpaceObjectWithRadius).isEqualTo(VELOCITY);
        assertThat(velocityOfSpaceObjectWithRadiusAtRest).isEqualTo(new Point3D(0,0,0));
    }

    @Test
    public void setsVelocity() throws Exception {
        Point3D newVelocity = new Point3D(3.1, -94.5, 0.08);

        spaceObjectWithoutRadius.setVelocity(newVelocity);
        spaceObjectWithoutRadiusAtRest.setVelocity(newVelocity);
        spaceObjectWithRadius.setVelocity(newVelocity);
        spaceObjectWithRadiusAtRest.setVelocity(newVelocity);

        Point3D actualVelocityWithoutRadius = spaceObjectWithoutRadius.getVelocity();
        Point3D actualVelocityWithoutRadiusAtRest = spaceObjectWithoutRadiusAtRest.getVelocity();
        Point3D actualVelocityWithRadius = spaceObjectWithoutRadius.getVelocity();
        Point3D actualVelocityWithRadiusAtRest = spaceObjectWithoutRadiusAtRest.getVelocity();

        assertThat(actualVelocityWithoutRadius).isEqualTo(newVelocity);
        assertThat(actualVelocityWithoutRadiusAtRest).isEqualTo(newVelocity);
        assertThat(actualVelocityWithRadius).isEqualTo(newVelocity);
        assertThat(actualVelocityWithRadiusAtRest).isEqualTo(newVelocity);
    }

    @Test
    public void returnsCorrectMass() throws Exception {
        double massOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getMass();
        double massOfSpaceObjectWithoutRadiusAtRest = spaceObjectWithoutRadiusAtRest.getMass();
        double massOfSpaceObjectWithRadius = spaceObjectWithRadius.getMass();
        double massOfSpaceObjectWithRadiusAtRest = spaceObjectWithRadiusAtRest.getMass();

        assertThat(massOfSpaceObjectWithoutRadius).isEqualTo(MASS);
        assertThat(massOfSpaceObjectWithoutRadiusAtRest).isEqualTo(MASS);
        assertThat(massOfSpaceObjectWithRadius).isEqualTo(MASS);
        assertThat(massOfSpaceObjectWithRadiusAtRest).isEqualTo(MASS);
    }

    @Test
    public void returnsCorrectRadius() throws Exception {
        double radiusOfSpaceObjectWithoutRadius = spaceObjectWithoutRadius.getRadius();
        double radiusOfSpaceObjectWithoutRadiusAtRest = spaceObjectWithoutRadiusAtRest.getRadius();
        double radiusOfSpaceObjectWithRadius = spaceObjectWithRadius.getRadius();
        double radiusOfSpaceObjectWithRadiusAtRest = spaceObjectWithRadiusAtRest.getRadius();

        assertThat(radiusOfSpaceObjectWithoutRadius).isEqualTo(0);
        assertThat(radiusOfSpaceObjectWithoutRadiusAtRest).isEqualTo(0);
        assertThat(radiusOfSpaceObjectWithRadius).isEqualTo(radiusOfSpaceObjectWithRadius);
        assertThat(radiusOfSpaceObjectWithRadiusAtRest).isEqualTo(radiusOfSpaceObjectWithRadiusAtRest);
    }
}
