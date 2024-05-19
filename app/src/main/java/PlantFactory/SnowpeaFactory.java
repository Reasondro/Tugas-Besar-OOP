package PlantFactory;

import Plants.Plant;
import Plants.Snowpea;

public class SnowpeaFactory extends PlantFactory{

    private static int snowpeaCount = 0;

    public SnowpeaFactory()
    {
        super("Snowpea Card", 10);
    }


    public Plant createPlant()
    {
        snowpeaCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Snowpea();
    }

    public static int getSnowpeaCount()
    {
        return snowpeaCount;
    }
    
}
