package comets;

public class Main {
    public static final double TIME_STEP = 1; //1 day
    public static final double EXPERIMENT_DURATION = 365;
    public static World world;
    private static double step = 0;

    public static void main(String[] args) {
        prepare();
        update();
    }

    private static void prepare() {
        world = new World();

        DataManip.parse("planets.txt").forEach(world::addSpaceObject);
        world.getSpaceObjects().forEach(System.out::println);
    }

    private static void update() {
        while (step < EXPERIMENT_DURATION) {
            world.calculateForces();

            world.getSpaceObjects().forEach(System.out::println);
            step += TIME_STEP;
        }
    }
}
