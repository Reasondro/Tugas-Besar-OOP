package PlantFactory;

import Plants.Plant;
import Plants.Snowpea;
import Plants.Kernelpult;
import Plants.Piercer;

public class PiercerFactory extends PlantFactory {

    private static int  piercerCount = 0;

    public PiercerFactory()
    {
        super("Piercer Card", 10,false, 120);     
    

    }

    public Plant createPlant()
    {
        piercerCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Piercer();
    }

    public static int getPiercerCount()
    {
        return   piercerCount;
    }
    
}