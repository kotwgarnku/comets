package comets;

import javafx.geometry.Point3D;
import org.junit.Test;

public class UpdateTest {

    @Test
    public void calculatesCorrectResultForForce() throws Exception {
        SpaceObject comet = new SpaceObject("comet", new Point3D(0,3.84e8,0), 7.349e22);
        Update update = new Update();
        update.calculateVelocity(comet, 100, 10000);
    }
}