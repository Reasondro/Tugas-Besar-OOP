package PlantFactory;

import Plants.Plant;
<<<<<<< HEAD
import Plants.Snowpea;
=======
import Plants.Kernelpult;
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
import Plants.Kernelpult;

public class KernelpultFactory extends PlantFactory {

    private static int kernelPultCount = 0;

    public KernelpultFactory()
    {
<<<<<<< HEAD
        super("Kernelpult Card", 10,false, 200);     
=======
        super("Kernelpult Card", 10,false, 140);     
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b


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