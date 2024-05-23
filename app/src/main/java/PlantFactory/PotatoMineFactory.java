package PlantFactory;

import Plants.Plant;
import Plants.PotatoMine;

public class PotatoMineFactory extends PlantFactory {
    
    private static int squashCount = 0;


    public PotatoMineFactory()
    {
        super("PotatoMine Card", 10, false, 25);
    }

    public Plant createPlant()
    {
        squashCount++;
        PlantFactory.incrementPlantCount();

        setCooldownTimer(getFactoryCooldown());
        setReady(false);

        return new PotatoMine();
    }

    public static int getSquashCount()
    {
        return squashCount;
    }

}
