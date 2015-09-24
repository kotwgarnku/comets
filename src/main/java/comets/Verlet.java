package comets;

public class Verlet implements MovementIntegrator {
    private Equation equation;

    public Verlet(Equation equation) {
        this.equation = equation;
    }

    @Override
    public void evaluate(State state, double t, double dt) {
        if (state.getPreviousPosition() != null) {
            state.updatePosition(state.getPosition().subtract(state.getPreviousPosition())
                            .add(equation.f(state, t).multiply(dt * dt))
            );
            state.setVelocity(state.getPosition().subtract(state.getPreviousPosition()).multiply(1 / dt));
        } else {
            state.updateVelocity(state.getForce().multiply(dt));
            state.updatePosition(state.getVelocity().multiply(dt));
        }

    }
}
