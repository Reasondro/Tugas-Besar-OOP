package PlantFactory;

import Plants.Plant;
import Plants.Wallnut;

public class WallnutFactory extends PlantFactory {

    private static int wallnutCount = 0;

    public WallnutFactory()
    {
        super("Wallnut Card", 20);
    }

    public Plant createPlant()
    {
        wallnutCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Wallnut();
    }

    public static int getWallnutCount()
    {
        return wallnutCount;
    }
    
}
