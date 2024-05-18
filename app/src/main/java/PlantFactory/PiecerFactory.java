package PlantFactory;

import Plants.Piercer;
import Plants.Plant;

public class PiecerFactory extends PlantFactory {

    private static int PiercerFactory = 0;
    public Plant createPlant()
    {
        PiercerFactory++;
        PlantFactory.incrementPlantCount();

        return new Piercer();
    }

    public static int getCoffeeBeanCount()
    {
        return PiercerFactory;
    }
    
}
