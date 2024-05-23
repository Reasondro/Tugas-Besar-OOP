package Threads;

import GameMap.GameMap;
import Petak.Petak;

import ZombieFactory.*;
import Zombies.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ZombieThread implements Runnable {

    private static volatile ZombieThread instance = null;

    private ZombieThread() {
    }

    public static ZombieThread getInstance() {
        if (instance == null) {
            synchronized (ZombieThread.class) {
                if (instance == null) {
                    instance = new ZombieThread();
                }
            }
        }
        return instance;
    }


    Random rand = new Random();

    GameMap map = GameMap.getInstance();


    List<Petak> zombieBase = GameMap.getInstance().getZombieBase();
    List<Zombie> zombies = new ArrayList<Zombie>();

    BucketheadZombieFactory bucketheadZombieFactory = new BucketheadZombieFactory();
    ConeheadZombieFactory coneheadZombieFactory = new ConeheadZombieFactory();
    DuckyTubeZombieFactory duckyTubeZombieFactory = new DuckyTubeZombieFactory();
    DolphinRiderZombieFactory dolphinRiderZombieFactory = new DolphinRiderZombieFactory();
    NormalZombieFactory normalZombieFactory = new NormalZombieFactory();
    PoleVaultingZombieFactory poleVaultingZombieFactory = new PoleVaultingZombieFactory();

    //? punya @Aurasindu
    DoubleAttackZombieFactory doubleAttackZombieFactory = new DoubleAttackZombieFactory();
    ExplosiveZombieFactory explosiveZombieFactory = new ExplosiveZombieFactory();
    RegenerativeZombieFactory regenerativeZombieFactory = new RegenerativeZombieFactory();
    StingZombieFactory stingZombieFactory = new StingZombieFactory();

    List<ZombieFactory> zombieFactories = Arrays.asList(bucketheadZombieFactory, coneheadZombieFactory, normalZombieFactory, poleVaultingZombieFactory
    , doubleAttackZombieFactory, explosiveZombieFactory, regenerativeZombieFactory, stingZombieFactory);
    List<ZombieFactory> aquaticZombieFactories = Arrays.asList(duckyTubeZombieFactory, dolphinRiderZombieFactory);

    
    public synchronized void removeZombies()
    {
        zombies.clear();
    }

    public synchronized boolean isAllZombiesDead()
    {
        boolean isAllZombiesDead = true;

        for(Zombie z : zombies)
        {
            if(z.getHealth() > 0)
            {
                isAllZombiesDead = false;
                break;
            }
        }
        return isAllZombiesDead;
    }

    public static boolean globalIsAllZombiesDead()
    {
        return getInstance().isAllZombiesDead();
    }

    public synchronized List<Zombie> getZombies()
    {
        return zombies;
    }
    
    public void resetFactories()
    {
        bucketheadZombieFactory.resetFactory();
        coneheadZombieFactory.resetFactory();
        duckyTubeZombieFactory.resetFactory();
        dolphinRiderZombieFactory.resetFactory();
        normalZombieFactory.resetFactory();
        poleVaultingZombieFactory.resetFactory();
        doubleAttackZombieFactory.resetFactory();
        explosiveZombieFactory.resetFactory();
        regenerativeZombieFactory.resetFactory();
        stingZombieFactory.resetFactory();

    }

    int zombieSpawnTimer;

    public int getZombieSpawnTimer()
    {
        return zombieSpawnTimer;
    }

    public void setZombieSpawnTimer(int zombieSpawnTimer)
    {
        this.zombieSpawnTimer = zombieSpawnTimer;
    }


    boolean gameRunning;
    
    @Override
    public void run()
     {   
        long  dayStart =  TimerThread.getDayStart();
        long tempStart = dayStart;
        setZombieSpawnTimer(0);

        boolean gameRunning = true;
        while (gameRunning) 
        {

            long currentTime = TimerThread.getCurrentTime();
            long timeElapsed = (currentTime - tempStart) / 1000; 

            if(isAllZombiesDead() && (timeElapsed > 21 && timeElapsed <= 160))
            {
                gameRunning = false;
                removeZombies();
                resetFactories();
                // System.out.println("All zombies are dead");
                break;
            }

            if(map.isProtectedBaseCompromised()) //? ini jga sama bisa pake factory cman nanti aja
            {
                gameRunning = false;
                removeZombies();
                resetFactories();
                break;
            }
        

            if (timeElapsed >= 200) 
            {
                tempStart = currentTime;
                continue;
            }

            //? spawn zombie logic
            if(timeElapsed >= 20 && timeElapsed <= 160)
            {
                if(getZombieSpawnTimer() == 0)
                {
                    for (Petak p : zombieBase) 
                    {
                        if(ZombieFactory.getZombieCount() < 10)
                        {
                            if(rand.nextDouble() < 0.3) 
                            {
                                if(p.getType().equals("Aquatic Zombie Base")) //? aquatic zombie base
                                {
                                    ZombieFactory factory = aquaticZombieFactories.get(rand.nextInt(aquaticZombieFactories.size()));
                                    Zombie zombie = factory.createZombie();
                                    p.addCreature(zombie);
                                    zombies.add(zombie);
                                }
                                else //? normal zombie base
                                {
                                    ZombieFactory factory = zombieFactories.get(rand.nextInt(zombieFactories.size()));
                                    Zombie zombie = factory.createZombie();
                                    p.addCreature(zombie);
                                    zombies.add(zombie);
                                }
                            }
                        }
                    }
                    setZombieSpawnTimer(3);
                }
                else
                {
                    setZombieSpawnTimer(getZombieSpawnTimer() - 1);
                }
            }
            
            //? zombie refresh logic


            for(Zombie z : zombies)
            {
                z.refreshZombie();
            }
            //? below for testing spawn mechanism
            // System.out.println("Zombie time elapsed: " + timeElapsed);
            // long tempZombieTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
            // long elapsedSeconds = tempZombieTime/1000;
            // long secondsDisplay = elapsedSeconds % 60;
            // long minutesDisplay = elapsedSeconds / 60;
            // System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
            // System.out.println("Zombie spawn timer: " + getZombieSpawnTimer());
            // map.printMap();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e)
             {
            System.out.println("Zombie Loop Interrupted");
            return;
            }
        }
        
    }


    
}
