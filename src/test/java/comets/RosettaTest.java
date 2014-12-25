package comets;

import org.junit.Test;

import static java.lang.Math.sqrt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

//http://rosettacode.org/wiki/Runge-Kutta_method

public class RosettaTest {
    private class RosettaFunction implements Equation {

        @Override
        public double f(double x, double y) {
            return x * sqrt(y);
        }
    }

    @Test
    public void calculatesCorrectResultForRosettaFunction() throws Exception {
        double y = 1;
        double dx = 0.005;
        RosettaFunction rosFunction = new RosettaFunction();
        for (double x = 0; x < 1; x += dx)
            y = RungeKutta4.evaluate(x, y, dx, rosFunction);

        assertThat(y).isCloseTo((25/16f), within(1E-10));
    }
}