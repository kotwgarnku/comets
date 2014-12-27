package comets;

import javafx.geometry.Point3D;
import org.junit.Test;

public class UpdateTest {

    @Test
    public void calculatesCorrectResultForForce() throws Exception {
        SpaceObject kometa = new SpaceObject("kometa", new Point3D(0,3.84e8,0), 7.349e22);
        Update update = new Update();
        update.calculateVelocity(kometa);
    }
}