package comets;

public interface MovementIntegrator {
    public void evaluate(State state, double t, double dt);
}
