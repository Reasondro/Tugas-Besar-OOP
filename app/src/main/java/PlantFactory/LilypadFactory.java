package PlantFactory;

import Plants.Plant;
import Plants.Lilypad;

public class LilypadFactory extends PlantFactory {

    private static int liliypadCount = 0;

    public Plant createPlant() {
        liliypadCount++;
        PlantFactory.incrementPlantCount();

        return new Lilypad();
    }

    public static int getLiliypadCount() {
        return liliypadCount;
    }
}
