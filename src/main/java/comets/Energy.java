package comets;

import java.util.ArrayList;

public class Energy {
    static double totalKineticEnergy;
    static double totalPotentialEnergy;
    static double totalEnergy;

    public static double calculateEnergy(ArrayList<SpaceObject> spaceObjects) {
        totalKineticEnergy = 0;
        totalPotentialEnergy = 0;
        totalEnergy = 0;
        double tmpVelocity;

        for(int i = 0; i < spaceObjects.size(); i++) {
        //kinetic energy
            tmpVelocity = spaceObjects.get(i).getVelocity().magnitude();
            totalKineticEnergy += spaceObjects.get(i).getMass() * tmpVelocity * tmpVelocity * 0.5;
        //potential energy
            for(int j = i+1; j < spaceObjects.size(); j++) {
                totalPotentialEnergy -= spaceObjects.get(i).getMass()*spaceObjects.get(j).getMass()/spaceObjects.get(i).getPosition().distance(spaceObjects.get(j).getPosition());
            }
            totalPotentialEnergy *= Gravity.GRAVITATIONAL_CONSTANT;
        }
        totalEnergy = totalKineticEnergy + totalPotentialEnergy;
        return totalEnergy;
    }
}
