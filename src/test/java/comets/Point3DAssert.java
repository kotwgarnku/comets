package comets;

import javafx.geometry.Point3D;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.data.Offset;

public class Point3DAssert extends AbstractAssert<Point3DAssert, Point3D> {

    public Point3DAssert(Point3D actual) {
        super(actual, Point3DAssert.class);
    }

    public static Point3DAssert assertThat(Point3D actual) {
        return new Point3DAssert(actual);
    }

    public Point3DAssert isCloseTo(Point3D point, Offset<Double> offset) {
        isNotNull();

        if (!arePointsCloseEnough(actual, point, offset.value)) {
            failWithMessage("\nExpecting:\n  <%s, %s, %s>\nto be close to:\n  <%s, %s, %s>\nby less than <%s, %s, %s> but difference was <%s, %s, %s>.\n(a difference of exactly <%s, %s, %s> being considered valid)",
                    actual.getX(), actual.getY(), actual.getZ(),
                    point.getX(), point.getY(), point.getZ(),
                    offset.value, offset.value, offset.value,
                    Math.abs(actual.getX() - point.getX()), Math.abs(actual.getY() - point.getY()), Math.abs(actual.getZ() - point.getZ()),
                    offset.value, offset.value, offset.value);
        }

        return this;
    }

    private boolean arePointsCloseEnough(Point3D a, Point3D b, double offset) {
        return areValuesCloseEnough(a.getX(), b.getX(), offset)
                && areValuesCloseEnough(a.getY(), b.getY(), offset)
                && areValuesCloseEnough(a.getZ(), b.getZ(), offset);
    }

    private boolean areValuesCloseEnough(double a, double b, double offset) {
        return a >= b - offset && a <= b + offset;
    }
}
