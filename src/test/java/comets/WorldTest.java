package comets;

import javafx.geometry.Point3D;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class WorldTest {

    public static final String NAME_OF_SPACE_OBJECT = "Space object";
    public static final Point3D POSITION = new Point3D(8.4, 10.2, 4.2);
    public static final double MASS = 10.3;
    public static final double RADIUS = 15.4;

    public static final String NAME_OF_SPACE_OBJECT_2 = "Space object 2";
    public static final Point3D POSITION_2 = new Point3D(1.3, 12.5, -5.5);
    public static final double MASS_2 = 12390.3;
    public static final double RADIUS_2 = 492.1;

    public static final SpaceObject spaceObject = new SpaceObject(NAME_OF_SPACE_OBJECT, POSITION, MASS, RADIUS);
    public static final SpaceObject spaceObject2 = new SpaceObject(NAME_OF_SPACE_OBJECT_2, POSITION_2, MASS_2, RADIUS_2);

    private ArrayList<SpaceObject> spaceObjectList;
    private World world;

    @Before
    public void setUp() throws Exception {
        spaceObjectList = new ArrayList<SpaceObject>();
        spaceObjectList.add(spaceObject);
        world = new World(spaceObjectList);
    }

    @Test
    public void returnsCorrectList() throws Exception {
        assertThat(world.getSpaceObjects()).isEqualTo(spaceObjectList);
    }

    @Test
    public void addsElement() throws Exception {
        world.addSpaceObject(spaceObject2);
        assertThat(world.getSpaceObjects().get(world.getSpaceObjects().size()-1)).isEqualTo(spaceObject2);
    }
}
