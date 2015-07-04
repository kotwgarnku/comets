package comets;

public class Main {
    public static final double TIME_STEP = 1; //1 day
    public static final double EXPERIMENT_DURATION = 365;
    private static World world;

    public static void main(String[] args) {
        prepare();
        update();
    }

    private static void prepare() {
        world = new World();
        world.addSpaceObjects(DataManip.parse("planets.txt"));
    }

    private static void update() {
        while (world.getTime() < EXPERIMENT_DURATION) {
            world.getSpaceObjects().forEach(System.out::println);

            world.calculateForces();
            world.getSpaceObjects().forEach(object -> object.doSimulationStep(world.getTime(), TIME_STEP));

            world.increaseTime(TIME_STEP);
            System.out.println();
        }
    }
}
