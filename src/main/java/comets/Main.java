package comets;

import javafx.geometry.Point3D;
import org.jzy3d.analysis.AnalysisLauncher;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class Main {
    public static final double TIME_STEP = 0.001;
    public static final double EXPERIMENT_DURATION = 365 * 3;
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
        List<List<Point3D>> planetsPoints = new ArrayList<>();
        world.getSpaceObjects().forEach(x -> planetsPoints.add(new ArrayList<>()));

        double previousDay = -1;
        while (world.getTime() < EXPERIMENT_DURATION) {
            double day = Math.floor(world.getTime());
            if (day != previousDay && day % 5 == 0) {
                range(0, world.getSpaceObjects().size())
                        .forEach(i -> planetsPoints.get(i).add(world.getSpaceObjects().get(i).getPosition()));
                previousDay = day;
                System.out.println(day / EXPERIMENT_DURATION * 100);
            }
            world.calculateForces();
            world.getSpaceObjects().forEach(object -> object.doSimulationStep(world.getTime(), TIME_STEP));

            world.increaseTime(TIME_STEP);
        }

        try {
            AnalysisLauncher.open(new ScatterDemo(planetsPoints));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
