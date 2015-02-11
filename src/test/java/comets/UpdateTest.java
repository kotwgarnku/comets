package comets;

import javafx.geometry.Point3D;
import org.junit.Test;

public class UpdateTest {

    @Test
    public void calculatesCorrectResultForForce() throws Exception {
        SpaceObject kometa = new SpaceObject("comet", new Point3D(1,19,10), 456);
        Update update = new Update();
        update.calculateVelocity();
    }
}