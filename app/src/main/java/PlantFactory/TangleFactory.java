package PlantFactory;

import Plants.Tangle;
import Plants.Plant;

public class TangleFactory extends PlantFactory {

    private static int tangleCount = 0;
    public Plant createPlant()
    {
        tangleCount++;
        PlantFactory.incrementPlantCount();

        return new Tangle();
    }

    public static int getTangleCount()
    {
        return tangleCount;
    }
    
}
