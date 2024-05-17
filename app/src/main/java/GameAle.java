import java.util.*;

import GameMap.GameMap;
import Plants.*;
import Zombies.*;
import Sun.*;
import java.util.*;
import Petak.*;
import Position.*;

public class GameAle{
    public static void main(String[] args)
    {
        float seconds = 0.0f;

        GameMap map = GameMap.getInstance();

        Sun mySun = Sun.getInstance();

        BulletPlant myBulletPlant = new BulletPlant();
        Squash mySquash = new Squash();
        Snowpea mySnowpea = new Snowpea();
        Peashooter myPeashooter = new Peashooter();
        Peashooter myPeashooter2 = new Peashooter();
        Sunflower mySunflower = new Sunflower();
        
        Position posP11 = new Position(1, 1);
        map.getPetak(posP11).addCreature(mySunflower);
        map.getPetak(posP11).addCreature(myPeashooter);

        ConeheadZombie myConeheadZombie = new ConeheadZombie();
        DolphinRiderZombie myDolphinRiderZombie = new DolphinRiderZombie();
        PoleVaultingZombie myPoleVaultingZombie = new PoleVaultingZombie();

        
        Position posP19 = new Position(1, 9);
        NormalZombie myNormalZombie = new NormalZombie();
        map.getPetak(posP19).addCreature(myNormalZombie);

        Position posP22 = new Position(2, 2);
        map.getPetak(posP22).addCreature(mySquash);

        
        Position posP24 = new Position(2, 4);
        map.getPetak(posP24).addCreature(myConeheadZombie);
        map.getPetak(posP24).addCreature(myDolphinRiderZombie);

        Position posP51 = new Position(5, 1);
        map.getPetak(posP51).addCreature(mySnowpea);

        Position posP52 = new Position(5, 2);
        map.getPetak(posP52).addCreature(myPeashooter2);

        Position pos61 = new Position(6, 1);
        
        Position posP62 = new Position(6, 2);
        map.getPetak(posP62).addCreature(myBulletPlant);
        
        
        Position posP63 = new Position(6, 3);
        map.getPetak(posP63).addCreature(myPoleVaultingZombie);
        
        //? below for non thread testing
        // map.printMap(); 

        // System.out.println("After removing all plants from petak 1,1 (sunflower and peashooter are gone)");
        // map.getPetak(posP11).removeAllPlants(); //? remove all plants from petak @mhmmdhakim
        // map.printMap(); 



        // mySunflower.checkToUseAbility();
        // myPeashooter.checkToUseAbility();

        // mySquash.checkToUseAbility();

         // myConeheadZombie.displayStatus();
        // System.out.println("After zombie attack");

        // myConeheadZombie.checkToWalk(); //? walkTimer @ went from 0 - 5. WALKING

        // myConeheadZombie.checkToWalk(); //? walkTimer @ went from 5 to 4. NOT WALKING
        // myConeheadZombie.checkToWalk(); //? walkTimer @ went from 4 to 3. NOT WALKING
        // myConeheadZombie.checkToWalk(); //? walkTimer @ went from 3 to 2. NOT WALKING
        // myConeheadZombie.checkToWalk(); //? walkTimer @ went from 2 to 1. NOT WALKING 
        // myConeheadZombie.checkToWalk(); //? walkTimer @ went from 1 to 0. NOT WALKING

        // myConeheadZombie.checkToWalk(); //? walkTimer @ went from 0 to 5. WALKING
        // myConeheadZombie.checkToAttack();
        
        // mySnowpea.checkToUseAbility();
        // myBulletPlant.checkToUseAbility();

        // map.printMap();
        // mySun.displayStatus();
        //? above for non-thread testing


        //? below for plant thread testing

        // map.printMap();


        final long  startTime =  System.currentTimeMillis();

        Thread gameThreadTest = new Thread() {
            @Override
            public void run() {
                while (true) {
                    // if(map.isProtectedBaseCompromised() || myPoleVaultingZombie.getHealth() == 0 || myBulletPlant.getHealth() == 0)
                    // {
                    //     break;
                    // }
                    final long currentTime = System.currentTimeMillis() - startTime;
                    final long elapsedSeconds = currentTime/1000;
                    final long secondsDisplay = elapsedSeconds % 60;
                    final long minutesDisplay = elapsedSeconds / 60;
                    System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
                    map.printMap();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        Thread plantThreadTest = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(map.isProtectedBaseCompromised() || myPoleVaultingZombie.getHealth() == 0 || myBulletPlant.getHealth() == 0)
                    {
                        break;
                    }
                    myBulletPlant.checkToUseAbility();
                    System.out.println("looping dari plant");
                    map.refreshMap();
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
                while (true) {
                    if(map.isProtectedBaseCompromised() ||  myPoleVaultingZombie.getHealth() == 0 || myBulletPlant.getHealth() == 0) //? could use zombie factory to check if all living zombie is dead
                    {
                        break;
                    }
                    myPoleVaultingZombie.useAbility();
                    System.out.println("looping dari zombie");
                    map.refreshMap();
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
            plantThreadTest.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        try{
            zombieThreadTest.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        gameThreadTest.start();
        // map.printMap();
        // map.getPetak(pos61).addCreature(new Sunflower());


        //? above for plant thread testing
        // map.printMap();
        // map.printMap();

        // map.printMap();
        // // map.isProtectedBaseCompromised();
        // map.printMap();

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