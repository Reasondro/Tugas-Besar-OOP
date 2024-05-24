package PlantFactory;

import Plants.Plant;
import Plants.Tangle;

public class TangleFactory  extends PlantFactory{

    private static int tangleCount = 0;

    public TangleFactory()
    {
        super("Tangle Card", 10, true, 50);     
    }

    public Plant createPlant()
    {

        tangleCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Tangle();
    }

    public static int getTangleCount()
    {
        return tangleCount;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
