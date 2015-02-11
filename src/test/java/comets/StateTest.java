package comets;

import javafx.geometry.Point3D;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    public static final Point3D POSITION = new Point3D(8.4, 10.2, 4.2);
    public static final Point3D VELOCITY = new Point3D(9.9, 12.34, -23.6);
    private State state;

    @Before
    public void setUp() throws Exception {
        state = new State(POSITION, VELOCITY);
    }

    @Test
    public void constructorsWithDefaultParametersSetZeroes() throws Exception {
        Point3D point = new Point3D(2, 81, 36);
        State state1 = new State();
        State state2 = new State(point);

        assertThat(state1.getPosition()).isEqualTo(Point3D.ZERO);
        assertThat(state1.getVelocity()).isEqualTo(Point3D.ZERO);
        assertThat(state2.getPosition()).isEqualTo(point);
        assertThat(state2.getVelocity()).isEqualTo(Point3D.ZERO);
    }

    @Test
    public void setsPosition() throws Exception {
        Point3D newPosition = new Point3D(6.2, -23.1, 2.32);

        state.setPosition(newPosition);

        assertThat(state.getPosition()).isEqualTo(newPosition);
    }

    @Test
    public void updatesPosition() throws Exception {
        Point3D changeInPosition = new Point3D(0.2, -0.8, 2.0);
        Point3D expectedNewPosition = POSITION.add(changeInPosition);

        state.updatePosition(changeInPosition);

        assertThat(state.getPosition()).isEqualTo(expectedNewPosition);
    }

    @Test
    public void returnsCorrectPosition() throws Exception {
        Point3D position = state.getPosition();

        assertThat(position).isEqualTo(POSITION);
    }

    @Test
    public void setsVelocity() throws Exception {
        Point3D newVelocity = new Point3D(3.1, -94.5, 0.08);

        state.setVelocity(newVelocity);

        assertThat(state.getVelocity()).isEqualTo(newVelocity);
    }

    @Test
    public void updatesVelocity() throws Exception {
        Point3D changeInVelocity = new Point3D(-0.6, 2.42, 3.79);
        Point3D expectedNewVelocity = VELOCITY.add(changeInVelocity);

        state.updateVelocity(changeInVelocity);

        assertThat(state.getVelocity()).isEqualTo(expectedNewVelocity);
    }

    @Test
    public void returnsCorrectVelocity() throws Exception {
        Point3D velocity = state.getVelocity();

        assertThat(velocity).isEqualTo(VELOCITY);
    }
}