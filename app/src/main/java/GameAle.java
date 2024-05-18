import java.util.*;

import GameMap.GameMap;
import Plants.*;
import PlantFactory.*;
import Zombies.*;
import ZombieFactory.*;
import Sun.*;
import java.util.concurrent.*; //? for CountDownLatch
import Petak.*;
import Position.*;

public class GameAle{
    public static void main(String[] args)
    {

        boolean isRunning = true;

        List<Plant> plants = new ArrayList<Plant>();

        GameMap map = GameMap.getInstance();

        Sun SUN = Sun.getInstance();

        // BulletPlant myBulletPlant = new BulletPlant();
        Sunflower mySunflower = new Sunflower();
        // plants.add(myBulletPlant);
        plants.add(mySunflower);

        Position pos61 = new Position(6, 1);
        map.getPetak(pos61).addCreature(new Sunflower());
        

        //? below for plant thread testing

        CountDownLatch latch = new CountDownLatch(2);

        final long  dayStart =  System.currentTimeMillis();
        
        Thread plantThreadTest = new Thread() 
        {
            @Override
            public void run() {
                Random rand = new Random();
                long tempStart = dayStart;
                long nextSunPointTime = 5 + rand.nextInt(6);
                while (true) {
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
                    if(timeElapsed <= 100)
                    {
                        if (timeElapsed >= nextSunPointTime) 
                        {
                            SUN.addSunPoints(25);
                            System.out.println("Got sun points from randomizer "+ SUN.getSunPoints());
                            nextSunPointTime = timeElapsed + 5 + rand.nextInt(6); //? Random delay between 5 and 10 seconds
                        }
                    }

                    for(Plant p : plants)
                    {
                        p.refreshPlant();
                    }
                    // myBulletPlant.refreshPlant();
                    latch.countDown();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread zombieThreadTest = new Thread() {
            @Override
            public void run() {
                Random rand = new Random();
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
                long tempStart = dayStart;
                
                while (true) {
                    if( map.isProtectedBaseCompromised()) //? could use zombie factory to check if all living zombie is dead cman nanti aja
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

                    for(Zombie z : zombies)
                    {
                        z.refreshZombie();
                    }
                    latch.countDown();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        plantThreadTest.start();
        zombieThreadTest.start();

        try{
            latch.await();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
        Thread gameThreadTest = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(map.isProtectedBaseCompromised())
                    {
                        break;
                    }
                    final long currentTime = System.currentTimeMillis() - dayStart;
                    final long elapsedSeconds = currentTime/1000;
                    final long secondsDisplay = elapsedSeconds % 60;
                    final long minutesDisplay = elapsedSeconds / 60;
                    System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);

                    map.printMap();
                    try {
                        Thread.sleep(1000);
                    // secondsPassed++;

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        gameThreadTest.start();

    //     while(isRunning)
    //     {
    //         if(map.isProtectedBaseCompromised())
    //         {
    //             isRunning = false;
    //             plantThreadTest.interrupt();
    //             zombieThreadTest.interrupt();
    //             gameThreadTest.interrupt();
    //             System.out.println("Game Over with time "+ secondsPassed + " seconds");
    //             break;
    //         }
    //         else
    //         {
    //             secondsPassed++;
    //         }
    //  }
}
}

///? Notes before adding bullet

   //     Game concurrency = new Game();
    //     Thread thread = new Thread(() -> {
    //         try {
    //             while (true) {
    //                 concurrency.gameLoop();
    //                 Thread.sleep(1000); // Sleep for 1 second
    //             }
    //         } catch (InterruptedException e) {
    //             System.out.println("Game Loop Interrupted");
    //         }
    //     });
    //     thread.start();

    //     boolean isRunning = true;
    //     Scanner scanner = new Scanner(System.in);
    //     String userInput;

    //     while (isRunning) {
    //         userInput = scanner.nextLine();
    //         if (userInput.equals("exit")) {
    //             isRunning = false;
    //             thread.interrupt();
    //             break;
    //         } else {
    //             System.out.println("Hello " + userInput + "!");
    //         }
    //     }

    //     scanner.close();
    // }

    // public void gameLoop() {
    //     System.out.println("Game Loop");