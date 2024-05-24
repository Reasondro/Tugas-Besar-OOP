package PlantFactory;

import Plants.Plant;
import Plants.BulletPlant;

public class BulletPlantFactory extends PlantFactory {

    private static int bulletPlantCount = 0;

    public BulletPlantFactory()
    {
        super("BulletPlant Card", 10,false, 100);     


    }

    public Plant createPlant()
    {
        bulletPlantCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new BulletPlant();
    }

    public static int getBulletPlant()
    {
        return bulletPlantCount;
    }
    
}