package PlantFactory;
import Plants.Plant;

public abstract class PlantFactory {
    private static int plantCount = 0;
    public abstract Plant createPlant();

    public static int getPlantCount()
    {
        return plantCount;
    }

    public static void incrementPlantCount()
    {
        plantCount++;
    }

}
