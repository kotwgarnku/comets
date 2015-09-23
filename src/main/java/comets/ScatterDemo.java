package comets;

import javafx.geometry.Point3D;
import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

// based on: https://github.com/jzy3d/jzy3d-api/blob/master/jzy3d-tutorials/src/main/java/org/jzy3d/demos/scatter/ScatterDemo.java
public class ScatterDemo extends AbstractAnalysis {
    private List<List<Point3D>> planetsPoints;

    public ScatterDemo(List<List<Point3D>> planetsPoints) {
        this.planetsPoints = planetsPoints;
    }

    public void init() {
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");

        List<Coord3d[]> coords = planetsPoints.stream().map(this::point3DtoCoord3d).collect(Collectors.toList());

        List<Color> colors = Arrays.asList(new Color(0f, 1f, 0f), new Color(0f, 0f, 1f), new Color(1f, 0f, 0f), new Color(0.5f, 0.5f, 0f), new Color(0.3f, 0.7f, 0.3f),
                new Color(0.5f, 0f, 0.5f), new Color(0f, 0.5f, 0.5f), new Color(0.5f, 0.5f, 0.5f), new Color(0.3f, 0.3f, 0.7f), new Color(0.7f, 0.3f, 0.3f), new Color(0f, 0f, 0f));

        range(0, coords.size())
                .forEach(i -> chart.getScene().add(new Scatter(coords.get(i), colors.get(i))));
    }

    private Coord3d[] point3DtoCoord3d(List<Point3D> points) {
        Coord3d[] coords = new Coord3d[points.size()];
        for (int i = 0; i < points.size(); i++) {
            Point3D point = points.get(i);
            coords[i] = new Coord3d(point.getX(), point.getY(), point.getZ());
        }
        return coords;
    }
}
