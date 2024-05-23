package PlantFactory;

import Plants.Plant;
import Plants.Tangle;

public class TangleFactory  extends PlantFactory{

    private static int tangleCount = 0;

    public TangleFactory()
    {
        super("Tanlge Card", 10, true, 50);     
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
}
