package comets;

import javafx.geometry.Point3D;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class DataManip {
    public static List<SpaceObject> parse(String fileName) {
        List<SpaceObject> spaceObjects = new ArrayList<>();

        try (Stream<String> input = Files.lines(Paths.get(fileName))) {
            input.forEach(line -> {
                Optional<SpaceObject> object = parseLine(line);
                if (object.isPresent())
                    spaceObjects.add(object.get());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spaceObjects;
    }

    private static Optional<SpaceObject> parseLine(String line) {
        SpaceObject spaceObject = null;
        Dictionary<String, Double> params = null;
        List<String> keys = Arrays.asList("posX", "posY", "posZ", "velX", "velY", "velZ", "mass", "radius");
        Point3D position, velocity;
        // TODO: handle wrong input
        if (!line.startsWith("#")) {
            String[] args = line.split("\\s+");
            String name = args[0];
            int i = 1;
            for(String key : keys) {
                params.put(key, Double.parseDouble(args[i]));
                i++;
            }
            position = new Point3D(params.get("posX"), params.get("posY"), params.get("posZ"));
            velocity = new Point3D(params.get("velX"), params.get("velY"), params.get("velZ"));
            spaceObject = new SpaceObject(name, position, params.get("mass"), params.get("radius"));
            spaceObject.setVelocity(velocity);
        }

        return Optional.ofNullable(spaceObject);
    }
}
