package PlantFactory;

import Plants.Plant;
import Plants.Squash;

public class SquashFactory extends PlantFactory {
    
    private static int squashCount = 0;


    public SquashFactory()
    {
        super("Squash Card", 20, false, 50);
    }

    public Plant createPlant()
    {
        squashCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Squash();
    }

    public static int getSquashCount()
    {
        return squashCount;
    }

}
