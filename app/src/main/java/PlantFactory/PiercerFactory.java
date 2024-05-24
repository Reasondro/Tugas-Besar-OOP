package PlantFactory;

import Plants.Plant;
import Plants.Snowpea;
import Plants.Kernelpult;
import Plants.Piercer;

public class PiercerFactory extends PlantFactory {

    private static int   piercerCount = 0;

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

<<<<<<< HEAD
        return new Kernelpult();
=======
        return new Piercer();
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
    }

    public static int getPiercerCount()
    {
        return   piercerCount;
    }
    
}