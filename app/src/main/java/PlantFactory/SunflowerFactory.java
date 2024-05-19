package PlantFactory;

import Plants.Plant;
import Plants.Sunflower;

public class SunflowerFactory extends PlantFactory{

    private static int sunflowerCount = 0;

    public SunflowerFactory()
    {
        super("Sunflower Card", 10);
    }


    public Plant createPlant()
    {
        sunflowerCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Sunflower();
    }

    public static int getSunflowerCount()
    {
        return sunflowerCount;
    }
    
}
