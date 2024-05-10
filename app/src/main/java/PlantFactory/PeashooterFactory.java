package PlantFactory;

import Plants.Plant;
import Plants.Peashooter;

public class PeashooterFactory extends PlantFactory {

    private static int peashooterCount = 0;
    public Plant createPlant()
    {
        peashooterCount++;
        PlantFactory.incrementPlantCount();

        return new Peashooter();
    }

    public static int getPeashooterCount()
    {
        return peashooterCount;
    }
    
}
