package PlantFactory;

import Plants.Plant;
import Plants.Snowpea;

public class SnowpeaFactory extends PlantFactory{

    private static int snowpeaCount = 0;
    public Plant createPlant()
    {
        snowpeaCount++;
        PlantFactory.incrementPlantCount();

        return new Snowpea();
    }

    public static int getSnowpeaCount()
    {
        return snowpeaCount;
    }
    
}
