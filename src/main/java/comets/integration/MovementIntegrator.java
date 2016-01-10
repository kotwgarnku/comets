package comets.integration;

import comets.State;

public interface MovementIntegrator {
    public void evaluate(State state, double t, double dt);
}
