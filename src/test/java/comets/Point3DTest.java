package comets;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Point3DTest {

    @Test
    public void subtractsPointsCoordinates() throws Exception {
        double x1 = 2.3, y1 = 3.4, z1 = 4.5;
        double x2 = 0.3, y2 = 1.35, z2 = -0.5;
        Point3D firstPoint = new Point3D(x1, y1, z1);
        Point3D secondPoint = new Point3D(x2, y2, z2);

        Point3D subtractionResult = firstPoint.subtract(secondPoint);

        Point3D expectedResult = new Point3D(x1-x2, y1-y2, z1-z2);
        assertThat(subtractionResult).isEqualTo(expectedResult);
    }
}