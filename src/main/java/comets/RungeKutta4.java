package comets;

public class RungeKutta4 {
    public static double evaluate(double x, double y, double dx, Equation derivative) {
        double k1 = dx * derivative.f(x, y);
        double k2 = dx * derivative.f(x + dx * 0.5, y + 0.5 * k1);
        double k3 = dx * derivative.f(x + dx * 0.5, y + 0.5 * k2);
        double k4 = dx * derivative.f(x + dx, y + k3);

        return y + (k1 + 2*k2 + 2*k3 + k4) / 6.0;
    }
}
