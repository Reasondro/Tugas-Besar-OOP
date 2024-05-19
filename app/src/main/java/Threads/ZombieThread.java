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

    List<ZombieFactory> zombieFactories = Arrays.asList(bucketheadZombieFactory, coneheadZombieFactory, normalZombieFactory, poleVaultingZombieFactory);
    List<ZombieFactory> aquaticZombieFactories = Arrays.asList(duckyTubeZombieFactory, dolphinRiderZombieFactory);

    
    public synchronized void removeZombies()
    {
        zombies.clear();
    }
    
    public void resetFactories()
    {
        bucketheadZombieFactory.resetFactory();
        coneheadZombieFactory.resetFactory();
        duckyTubeZombieFactory.resetFactory();
        dolphinRiderZombieFactory.resetFactory();
        normalZombieFactory.resetFactory();
        poleVaultingZombieFactory.resetFactory();
    }

    long  dayStart =  TimerThread.getDayStart();
    long tempStart = dayStart;
    
    @Override
    public void run()
     {
        while (true) 
        {
            // if(map.isProtectedBaseCompromised()) //? ini jga sama bisa pake factory cman nanti aja
            // {
            //     break;
            // }
            long currentTime = TimerThread.getCurrentTime();
            long timeElapsed = (currentTime - tempStart) / 1000; 

            if (timeElapsed >= 200) 
            {
                tempStart = currentTime;
                continue;
            }

            //? spawn zombie logic
            if(timeElapsed >= 20 && timeElapsed <= 160)
                    {
                        for (Petak p : zombieBase) 
                        {
                            if(ZombieFactory.getZombieCount() < 10)
                            {
                                if(rand.nextDouble() < 0.3) 
                                {
                                    if(p.getType().equals("Aquatic Zombie Base"))
                                    {
                                        ZombieFactory factory = aquaticZombieFactories.get(rand.nextInt(aquaticZombieFactories.size()));
                                        Zombie zombie = factory.createZombie();
                                        p.addCreature(zombie);
                                        zombies.add(zombie);
                                    }
                                    else
                                    {
                                        ZombieFactory factory = zombieFactories.get(rand.nextInt(zombieFactories.size()));
                                        Zombie zombie = factory.createZombie();
                                        p.addCreature(zombie);
                                        zombies.add(zombie);
                                    }
                                }
                            }
                        }
                    }
            
            //? zombie refresh logic


            for(Zombie z : zombies)
            {
                z.refreshZombie();
            }

            // System.out.println("Current Time from Zombie Thread: " + currentTime);

            // latch.countDown();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e)
             {
            map.resetMap();
            removeZombies();
            resetFactories();

            // System.out.println("Zombie Loop Interrupted");
            return;
            }
        }
        
    }


    
}
