package comets;

import javafx.geometry.Point3D;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RungeKutta4Test {

    public static final Point3D POSITION = new Point3D(-1.2, 32.1, 756.42);
    public static final Point3D VELOCITY = new Point3D(18, -6.8, -20);
    public static final Point3D ACCELERATION = new Point3D(1, 0, 0);
    public static final int DT = 5;
    private RungeKutta4 rk4zero;
    private RungeKutta4 rk4const;
    /*
    private class ExpFunction implements Equation {

        @Override
        public double f(double x, double y) {
            return y;
        }
    }

    @Test
    public void calculatesCorrectResultForExpFunction() throws Exception {
        double y = 1; // exp(0)
        double dxdt = 0.005;
        ExpFunction expFunction = new ExpFunction();
        for (double x = 0; x < 1; x += dxdt)
            y = RungeKutta4.evaluateOld(x, y, dxdt, expFunction);

        assertThat(y).isCloseTo(exp(1), within(1E-10));
    }

    // http://rosettacode.org/wiki/Runge-Kutta_method
    private class RosettaFunction implements Equation {

        @Override
        public double f(double x, double y) {
            return x * sqrt(y);
        }
    }

    @Test
    public void calculatesCorrectResultForRosettaFunction() throws Exception {
        double y = 1;
        double dxdt = 0.005;
        RosettaFunction rosFunction = new RosettaFunction();
        for (double x = 0; x < 1; x += dxdt)
            y = RungeKutta4.evaluateOld(x, y, dxdt, rosFunction);

        assertThat(y).isCloseTo((25/16f), within(1E-10));
    }
    */

    private class ZeroFunction implements Equation {

        @Override
        public Point3D f(State state, double t) {
            return Point3D.ZERO;
        }
    }

    private class ConstantFunction implements Equation {

        @Override
        public Point3D f(State state, double t) {
            return ACCELERATION;
        }
    }

    @Before
    public void setUp() throws Exception {
        rk4zero = new RungeKutta4(new ZeroFunction());
        rk4const = new RungeKutta4(new ConstantFunction());
    }

    @Test
    public void integratesCorrectlyForZeroVelocityAndAcceleration() throws Exception {
        State state = new State(POSITION);

        rk4zero.evaluate(state, DT, DT);

        assertThat(state.getPosition()).isEqualTo(POSITION);
        assertThat(state.getVelocity()).isEqualTo(Point3D.ZERO);
    }

    @Test
    public void integratesCorrectlyForZeroAcceleration() throws Exception {
        State state = new State(POSITION, VELOCITY);

        rk4zero.evaluate(state, DT, DT);
        Point3D expectedPosition = POSITION.add(VELOCITY.multiply(DT));

        assertThat(state.getPosition()).isEqualTo(expectedPosition);
        assertThat(state.getVelocity()).isEqualTo(VELOCITY);
    }

    @Test
    public void integratesCorrectlyForConstantAcceleration() throws Exception {
        State state = new State(POSITION, VELOCITY);

        rk4const.evaluate(state, DT, DT);
        // v = v_0 + a * dt
        Point3D expectedVelocity = VELOCITY.add(ACCELERATION.multiply(DT));
        // x = x_0 + v_0 * dt + a * dt * dt / 2
        Point3D expectedPosition = POSITION.add(VELOCITY.multiply(DT)).add(ACCELERATION.multiply(DT*DT/2f));

        assertThat(state.getPosition()).isEqualTo(expectedPosition);
        assertThat(state.getVelocity()).isEqualTo(expectedVelocity);
    }
}
