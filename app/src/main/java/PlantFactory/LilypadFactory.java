package PlantFactory;

import Plants.Plant;
import Plants.Lilypad;

public class LilypadFactory  extends PlantFactory{

    private static int liliypadCount = 0;

    public LilypadFactory()
    {
        super("Lilypad Factory", 10);
    }

    public Plant createPlant()
    {

        liliypadCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Lilypad();
    }

    public static int getLiliypadCount()
    {
        return liliypadCount;
    }
}
