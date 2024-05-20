package Threads;
import GameMap.GameMap;
import Plants.*;
import Sun.Sun;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Deck.Deck;
import PlantFactory.PlantFactory;

public class PlantThread implements Runnable 
{
    private static volatile PlantThread instance = null;

    private PlantThread()
    {
    }

    public static PlantThread getInstance() {
        if (instance == null) {
            synchronized (PlantThread.class) {
                if (instance == null) {
                    instance = new PlantThread();
                }
            }
        }
        return instance;
    }

    Random rand = new Random();

    GameMap map = GameMap.getInstance();
    Sun SUN = Sun.getInstance();

    List<Plant> plants = new ArrayList<Plant>();

    
    public synchronized void addPlant(Plant p)
    {
        plants.add(p);
    }
    
    public synchronized void removePlants()
    {
        plants.clear();
    }
    
    public  synchronized List<Plant> getPlants()
    {
        return plants;
    }
    
    boolean gameRunning;
    @Override
    public void run() 
    {
        long  dayStart =  TimerThread.getDayStart();
        long tempStart = dayStart;
        long nextSunPointTime = 5 + rand.nextInt(6);

        gameRunning = true;
        Deck<PlantFactory> deck = Deck.getInstance();
        while (gameRunning) 
        {

            long currentTime = TimerThread.getCurrentTime();
            long timeElapsed = (currentTime - tempStart) / 1000; 

            if(ZombieThread.globalIsAllZombiesDead() && (timeElapsed > 21 && timeElapsed <= 160))
            {
                gameRunning = false;
                map.refreshMap();
                // System.out.println("PLANTS SAY All zombies are dead");
                break;
            }
            if(map.isProtectedBaseCompromised()) //? ini jga sama bisa pake factory cman nanti aja
            {
                gameRunning = false;
                SUN.resetSunPoints();
            
                removePlants();
                break;
            }
  
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
                    // System.out.println("Got sun points from randomizer "+ SUN.getSunPoints());
                    nextSunPointTime = timeElapsed + 5 + rand.nextInt(6); //? Random delay between 5 and 10 seconds
                }
            }

            //? plant refresh logic


            synchronized (plants) //todo test thsi
            {
                for(Plant p : plants)
                {
                    p.refreshPlant();
                }
            }


            deck.refresh();
            // System.out.println("Current Time from Plant Thread: " + currentTime);
    
            try {
                Thread.sleep(1000);
       
            } catch (InterruptedException e) {
            // gameRunning = false;
            // SUN.resetSunPoints();
        
            // removePlants();
            System.out.println("Plant Loop Interrupted");
           
            return;
            }
        }
        
    }
        
}
