package PlantFactory;

import Plants.Plant;
import Plants.Wallnut;

public class WallnutFactory extends PlantFactory {

    private static int wallnutCount = 0;
    public Plant createPlant()
    {
        wallnutCount++;
        PlantFactory.incrementPlantCount();

        return new Wallnut();
    }

    public static int getWallnutCount()
    {
        return wallnutCount;
    }
    
}
