package comets;

import javafx.geometry.Point3D;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UpdateTest {

    @Test
    public void calculatesCorrectResultForForce() throws Exception {
        SpaceObject kometa = new SpaceObject("kometa", new Point3D(1,19,10), 456);
        Update update = new Update();
        update.calculateVelocity();
        assertThat(2).isEqualTo(3);
    }
}