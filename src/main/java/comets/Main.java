package comets;

public class Main {
    public static final double TIME_STEP = 1; //seconds
    public static final double EXPERIMENT_DURATION = 2*60*60*24; //days? years?

    private static double step = 0;
    public static World world;

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
        while(step < EXPERIMENT_DURATION) {
        //calculations here
            //for every pair of objects calculate forces between them

            world.getSpaceObjects().forEach(System.out::println);
            step += TIME_STEP;
        }
    }
}
