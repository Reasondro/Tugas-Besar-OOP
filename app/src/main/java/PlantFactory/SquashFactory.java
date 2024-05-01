package PlantFactory;

import Plants.Plant;
import Plants.Squash;

public class SquashFactory extends PlantFactory {
    
    private static int squashCount = 0;
    public Plant createPlant()
    {
        squashCount++;
        PlantFactory.incrementPlantCount();

        return new Squash();
    }

    public static int getSquashCount()
    {
        return squashCount;
    }

}
