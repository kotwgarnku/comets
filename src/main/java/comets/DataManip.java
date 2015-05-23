package comets;

import javafx.geometry.Point3D;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class DataManip {
    public static ArrayList<SpaceObject> parse(String fileName) {
        ArrayList<SpaceObject> spaceObjects = new ArrayList<>();

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
        // TODO: handle wrong input
        if (!line.startsWith("#")) {
            String[] args = line.split("\\s+");
            String name = args[0];
            double posX = Double.parseDouble(args[1]);
            double posY = Double.parseDouble(args[2]);
            double posZ = Double.parseDouble(args[3]);
            double velX = Double.parseDouble(args[4]);
            double velY = Double.parseDouble(args[5]);
            double velZ = Double.parseDouble(args[6]);
            double mass = Double.parseDouble(args[7]);
            double radius = Double.parseDouble(args[8]);

            spaceObject = new SpaceObject(name, new Point3D(posX, posY, posZ), mass, radius);
            spaceObject.setVelocity(new Point3D(velX, velY, velZ));
        }

        return Optional.ofNullable(spaceObject);
    }
}
