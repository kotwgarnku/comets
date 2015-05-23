package comets;

public class Main {
    public static void main(String[] args) {
        World world = new World();

        DataManip.parse("planets.txt").forEach(world::addSpaceObject);

        world.getSpaceObjects().forEach(System.out::println);
    }
}
