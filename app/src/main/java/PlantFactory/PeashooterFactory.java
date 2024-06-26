package PlantFactory;

import Plants.Plant;
import Plants.Peashooter;

public class PeashooterFactory extends PlantFactory {

    private static int peashooterCount = 0;

    public PeashooterFactory()
    {
        super("Peashooter Card", 10, false, 100);

    }

    public Plant createPlant()
    {
        peashooterCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new Peashooter();
    }

    public static int getPeashooterCount()
    {
        return peashooterCount;
    }
    
}
