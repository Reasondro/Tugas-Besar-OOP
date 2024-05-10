package PlantFactory;

import Plants.Plant;
import Plants.Sunflower;

public class SunflowerFactory extends PlantFactory{

    private static int sunflowerCount = 0;
    public Plant createPlant()
    {
        sunflowerCount++;
        PlantFactory.incrementPlantCount();

        return new Sunflower();
    }

    public static int getSunflowerCount()
    {
        return sunflowerCount;
    }
    
}
