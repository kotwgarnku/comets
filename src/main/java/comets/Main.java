package comets;

import javafx.geometry.Point3D;
import org.jzy3d.analysis.AnalysisLauncher;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class Main {
    public static final double TIME_STEP = 0.01;
    public static final double EXPERIMENT_DURATION = 365 * 3;
    public static final int PLOT_EVERY_NTH_DAY = 10;

    private static World world;
    private static List<List<Point3D>> planetsPoints;
    private static int previousDay;

    public static void main(String[] args) {
        prepare();
        update();
    }

    private static void prepare() {
        world = new World();
        world.addSpaceObjects(DataManip.parse("planets.txt"));
        planetsPoints = new ArrayList<>();
        world.getSpaceObjects().forEach(x -> planetsPoints.add(new ArrayList<>()));
        previousDay = -1;
    }

    private static void update() {
        while (world.getTime() < EXPERIMENT_DURATION) {
            int day = (int) world.getTime();
            if (shouldPlot(day)) {
                addToPlot(day);
                printProgress(day);
            }

            world.calculateForces();
            world.getSpaceObjects().forEach(object -> object.doSimulationStep(world.getTime(), TIME_STEP));

            world.increaseTime(TIME_STEP);
        }

        openPlot();
    }

    private static boolean shouldPlot(int day) {
        return day != previousDay && day % PLOT_EVERY_NTH_DAY == 0;
    }

    private static void addToPlot(int day) {
        range(0, world.getSpaceObjects().size())
                .forEach(i -> planetsPoints.get(i).add(world.getSpaceObjects().get(i).getPosition()));
        previousDay = day;
    }

    private static void printProgress(float day) {
        System.out.println(String.format("%.2f%%", day / EXPERIMENT_DURATION * 100));
    }

    private static void openPlot() {
        try {
            AnalysisLauncher.open(new ScatterDemo(planetsPoints));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
