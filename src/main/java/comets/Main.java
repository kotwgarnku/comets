package comets;

import javafx.geometry.Point3D;
import org.jzy3d.analysis.AnalysisLauncher;

import java.util.ArrayList;
import java.util.List;

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
        List<List<Point3D>> planetsPoints = new ArrayList<>();
        world.getSpaceObjects().forEach(x -> planetsPoints.add(new ArrayList<>()));
        while (world.getTime() < EXPERIMENT_DURATION) {
            //world.getSpaceObjects().forEach(System.out::println);
            for (int i = 0; i < world.getSpaceObjects().size(); i++) {
                planetsPoints.get(i).add(world.getSpaceObjects().get(i).getPosition());
            }

            world.calculateForces();
            world.getSpaceObjects().forEach(object -> object.doSimulationStep(world.getTime(), TIME_STEP));

            world.increaseTime(TIME_STEP);
            //System.out.println();
        }

        try {
            AnalysisLauncher.open(new ScatterDemo(planetsPoints));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
