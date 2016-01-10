package comets.integration;

import comets.Equation;
import comets.State;
import javafx.geometry.Point3D;

public class RungeKutta4 implements MovementIntegrator {
    private Equation equation;

    public RungeKutta4(Equation equation) {
        this.equation = equation;
    }

    private Derivative calculate(State initial, double t, double dt, Derivative d) {
        Derivative output = new Derivative();
        output.dxdt = initial.getVelocity().add(d.dvdt.multiply(dt));
        output.dvdt = equation.f(initial, t+dt);
        return output;
    }

    @Override
    public void evaluate(State state, double t, double dt) {
        Derivative a, b, c, d;

        a = calculate(state, t, 0, new Derivative());
        b = calculate(state, t, dt * 0.5, a);
        c = calculate(state, t, dt * 0.5, b);
        d = calculate(state, t, dt, c);

        Point3D dx = a.dxdt
                .add(b.dxdt.multiply(2))
                .add(c.dxdt.multiply(2))
                .add(d.dxdt)
                .multiply(dt / 6);
        Point3D dv = a.dvdt
                .add(b.dvdt.multiply(2))
                .add(c.dvdt.multiply(2))
                .add(d.dvdt)
                .multiply(dt / 6);

        state.updatePosition(dx);
        state.updateVelocity(dv);
    }
}
