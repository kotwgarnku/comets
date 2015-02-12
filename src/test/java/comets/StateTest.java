package comets;

import javafx.geometry.Point3D;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    public static final Point3D POSITION = new Point3D(8.4, 10.2, 4.2);
    public static final Point3D POSITION2 = new Point3D(6.2, -23.1, 2.32);
    public static final Point3D VELOCITY = new Point3D(9.9, 12.34, -23.6);
    public static final Point3D VELOCITY2 = new Point3D(3.1, -94.5, 0.08);
    public static final Point3D FORCE = new Point3D(231.23, -421.2, -32.2312);
    private State state;

    @Before
    public void setUp() throws Exception {
        state = new State(POSITION, VELOCITY);
    }

    @Test
    public void constructorsWithDefaultParametersSetZeroes() throws Exception {
        State state1 = new State();
        State state2 = new State(POSITION2);

        assertThat(state1.getPosition()).isEqualTo(Point3D.ZERO);
        assertThat(state1.getVelocity()).isEqualTo(Point3D.ZERO);
        assertThat(state2.getPosition()).isEqualTo(POSITION2);
        assertThat(state2.getVelocity()).isEqualTo(Point3D.ZERO);
    }

    @Test
    public void setsPosition() throws Exception {
        state.setPosition(POSITION2);

        assertThat(state.getPosition()).isEqualTo(POSITION2);
    }

    @Test
    public void updatesPosition() throws Exception {
        state.updatePosition(POSITION2);
        Point3D expectedNewPosition = POSITION.add(POSITION2);

        assertThat(state.getPosition()).isEqualTo(expectedNewPosition);
    }

    @Test
    public void returnsCorrectPosition() throws Exception {
        Point3D position = state.getPosition();

        assertThat(position).isEqualTo(POSITION);
    }

    @Test
    public void setsPreviousPosition() throws Exception {
        state.setPreviousPosition(POSITION2);

        assertThat(state.getPreviousPosition()).isEqualTo(POSITION2);
    }

    @Test
    public void returnsPreviousPosition() throws Exception {
        Point3D previousPosition = state.getPreviousPosition();

        assertThat(previousPosition).isEqualTo(Point3D.ZERO);
    }

    @Test
    public void setsVelocity() throws Exception {
        state.setVelocity(VELOCITY2);

        assertThat(state.getVelocity()).isEqualTo(VELOCITY2);
    }

    @Test
    public void updatesVelocity() throws Exception {
        state.updateVelocity(VELOCITY2);
        Point3D expectedNewVelocity = VELOCITY.add(VELOCITY2);

        assertThat(state.getVelocity()).isEqualTo(expectedNewVelocity);
    }

    @Test
    public void returnsCorrectVelocity() throws Exception {
        Point3D velocity = state.getVelocity();

        assertThat(velocity).isEqualTo(VELOCITY);
    }

    @Test
    public void setsPreviousVelocity() throws Exception {
        state.setPreviousVelocity(VELOCITY2);

        assertThat(state.getPreviousVelocity()).isEqualTo(VELOCITY2);
    }

    @Test
    public void returnsPreviousVelocity() throws Exception {
        Point3D previousVelocity = state.getPreviousVelocity();

        assertThat(previousVelocity).isEqualTo(Point3D.ZERO);
    }

    @Test
    public void setForce() throws Exception {
        state.setForce(FORCE);

        assertThat(state.getForce()).isEqualTo(FORCE);
    }

    @Test
    public void returnsZeroForceAtStart() throws Exception {
        Point3D force = state.getForce();

        assertThat(force).isEqualTo(Point3D.ZERO);
    }
}