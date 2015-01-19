package comets;

import javafx.geometry.Point3D;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataManip {
    public static ArrayList<SpaceObject> parse(String fileName) {
        ArrayList<SpaceObject> spaceObjects = new ArrayList<>();
        String name = "defaultName";
        double posX = 0;
        double posY = 0;
        double posZ = 0;
        double velX = 0;
        double velY = 0;
        double velZ = 0;
        double mass = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split("\\s+");
                name = args[0];
                posX = Double.parseDouble(args[1]);
                posY = Double.parseDouble(args[2]);
                posZ = Double.parseDouble(args[3]);
                velX = Double.parseDouble(args[4]);
                velY = Double.parseDouble(args[5]);
                velZ = Double.parseDouble(args[6]);
                mass = Double.parseDouble(args[7]);
                SpaceObject newSpaceObject = new SpaceObject(name, new Point3D(posX, posY, posZ), mass);
                newSpaceObject.setVelocity(new Point3D(velX, velY, velZ));
                spaceObjects.add(newSpaceObject);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return spaceObjects;
    }
}
