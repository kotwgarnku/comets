package comets;

import javafx.geometry.Point3D;
import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import java.util.ArrayList;
import java.util.List;

// based on: https://github.com/jzy3d/jzy3d-api/blob/master/jzy3d-tutorials/src/main/java/org/jzy3d/demos/scatter/ScatterDemo.java
public class ScatterDemo extends AbstractAnalysis {
    ArrayList<Coord3d[]> coords;

    public ScatterDemo(List<List<Point3D>> points) {
        coords = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            coords.add(point3DtoCoord3d(points.get(i)));
        }
    }

    private Coord3d[] point3DtoCoord3d(List<Point3D> points) {
        Coord3d[] coords = new Coord3d[points.size()];
        for (int i = 0; i < points.size(); i++) {
            Point3D point = points.get(i);
            coords[i] = new Coord3d(point.getX(), point.getY(), point.getZ());
        }
        return coords;
    }

    public void init() {
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");

        Color[] colors = new Color[] {new Color(1f, 0f, 0f), new Color(0f, 1f, 0f), new Color(0f, 0f, 1f), new Color(0.5f, 0.5f, 0f)};

        for (int i = 0; i < colors.length; i++) {
            chart.getScene().add(new Scatter(coords.get(i), colors[i]));
        }
    }
}
