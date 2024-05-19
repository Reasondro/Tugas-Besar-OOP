package Threads;
import GameMap.GameMap;
import Plants.*;
import Sun.Sun;
import PlantFactory.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlantThread implements Runnable 
{
    Random rand = new Random();

    GameMap map = GameMap.getInstance();
    Sun SUN = Sun.getInstance();

    List<Plant> plants = new ArrayList<Plant>();

    final long  dayStart =  System.currentTimeMillis();
    long tempStart = dayStart;
    long nextSunPointTime = 5 + rand.nextInt(6);

    public synchronized void addPlant(Plant p)
    {
        plants.add(p);
    }
    
    public synchronized void removePlants()
    {
        plants.clear();
    }

    public synchronized List<Plant> getPlants()
    {
        return plants;
    }


    @Override
    public void run() 
    {
        while (true) 
        {
            if(map.isProtectedBaseCompromised()) //? ini jga sama bisa pake factory cman nanti aja
            {
                break;
            }
            long currentTime = System.currentTimeMillis();
            long timeElapsed = (currentTime - tempStart) / 1000; 

            if (timeElapsed >= 200) 
            {
                tempStart = currentTime;
                continue;
            }

            //? sun points randomizer
            if(timeElapsed <= 100)
            {
                if (timeElapsed >= nextSunPointTime) 
                {
                    SUN.addSunPoints(25);
                    System.out.println("Got sun points from randomizer "+ SUN.getSunPoints());
                    nextSunPointTime = timeElapsed + 5 + rand.nextInt(6); //? Random delay between 5 and 10 seconds
                }
            }

            //? plant refresh logic
            for(Plant p : plants)
            {
                p.refreshPlant();
            }
    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            SUN.resetSunPoints();
            removePlants();
            System.out.println("Plant Loop Interrupted");
            return;
            }
        }
        
    }
        
}
