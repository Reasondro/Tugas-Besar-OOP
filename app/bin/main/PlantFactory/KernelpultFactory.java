package PlantFactory;

import Plants.Plant;
import Plants.Snowpea;
import Plants.Kernelpult;

public class KernelpultFactory extends PlantFactory {

    private static int kernelPultCount = 0;

    public KernelpultFactory()
    {
        super("Kernelpult Card", 10,false, 200);     


    }

    public Plant createPlant()
    {
        kernelPultCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Kernelpult();
    }

    public static int getKernelPultCount()
    {
        return kernelPultCount;
    }
    
}