package PlantFactory;

import Plants.PotatoMine;
import Plants.Plant;

public class PotatoMineFactory extends PlantFactory {

    private static int potatoMineCount = 0;
    public Plant createPlant()
    {
        potatoMineCount++;
        PlantFactory.incrementPlantCount();

        return new PotatoMine();
    }

    public static int getPotatoMineCount()
    {
        return potatoMineCount;
    }
    
}
