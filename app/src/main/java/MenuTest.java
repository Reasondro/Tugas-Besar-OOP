
import PlantFactory.*;

import java.util.ArrayList;
import java.util.List;

public class MenuTest {

    public static void main(String[] args)
    {
        LilypadFactory lilypadFactory = new LilypadFactory();
        PeashooterFactory peashooterFactory = new PeashooterFactory();
        SunflowerFactory sunflowerFactory = new SunflowerFactory();
        SnowpeaFactory snowpeaFactory = new SnowpeaFactory();
        SquashFactory squashFactory = new SquashFactory();
        WallnutFactory wallnutFactory = new WallnutFactory();

        List<PlantFactory> plantFactories = new ArrayList<PlantFactory>();
        plantFactories.add(lilypadFactory);
        plantFactories.add(peashooterFactory);
        plantFactories.add(sunflowerFactory);
        plantFactories.add(snowpeaFactory);
        plantFactories.add(squashFactory);
        plantFactories.add(wallnutFactory);


        for(PlantFactory plantFactory : plantFactories)
        {
            plantFactory.createPlant();
        }

        for(PlantFactory plantFactory : plantFactories)
        {
            plantFactory.displayStatus();
        }

        System.out.println("After refresh 10 times");

        for(PlantFactory plantFactory : plantFactories)
        {

            for(int i = 0; i < 10; i++)
            {
                plantFactory.refreshFactory();
            }
        }

        for(PlantFactory plantFactory : plantFactories)
        {
            plantFactory.displayStatus();
        }
    
    }
}
