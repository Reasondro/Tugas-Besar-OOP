import java.util.*;

import GameMap.GameMap;
import Plants.*;
import Zombies.*;
import Sun.*;
import java.util.concurrent.*; //? for CountDownLatch
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
        // map.getPetak(posP11).addCreature(mySunflower);
        // map.getPetak(posP11).addCreature(myPeashooter);

        ConeheadZombie myConeheadZombie = new ConeheadZombie();
        DolphinRiderZombie myDolphinRiderZombie = new DolphinRiderZombie();
        PoleVaultingZombie myPoleVaultingZombie = new PoleVaultingZombie();

        
        Position posP19 = new Position(1, 9);
        NormalZombie myNormalZombie = new NormalZombie();
        // map.getPetak(posP19).addCreature(myNormalZombie);

        Position posP22 = new Position(2, 2);
        // map.getPetak(posP22).addCreature(mySquash);

        
        Position posP24 = new Position(2, 4);
        // map.getPetak(posP24).addCreature(myConeheadZombie);
        // map.getPetak(posP24).addCreature(myDolphinRiderZombie);

        Position posP51 = new Position(5, 1);
        // map.getPetak(posP51).addCreature(mySnowpea);

        Position posP52 = new Position(5, 2);
        // map.getPetak(posP52).addCreature(myPeashooter2);

        Position posP59 = new Position(5, 9);

        Position posP61 = new Position(6, 1);
        map.getPetak(posP61).addCreature(myPeashooter2);

        Position posP62 = new Position(6, 2);
        map.getPetak(posP62).addCreature(myBulletPlant);

        Position pos63 = new Position(6, 3);
        map.getPetak(pos63).addCreature(new Sunflower());
        
        
        NormalZombie x = new NormalZombie();
        ConeheadZombie y = new ConeheadZombie();

        Position posP68 = new Position(6, 8);
        map.getPetak(posP68).addCreature(myPoleVaultingZombie);
        // map.getPetak(posP66).addCreature(x);
        // map.getPetak(posP68).addCreature(y);

        Position posP69 = new Position(6, 9);
        map.getPetak(posP69).addCreature(y);
        // map.getPetak(posP69).addCreature(myPoleVaultingZombie);
        map.getPetak(posP69).addCreature(x);



        //? below for plant thread testing

        // map.printMap();

        // CountDownLatch latch = new CountDownLatch(2);


        final long  startTime =  System.currentTimeMillis();


        
        Thread plantThreadTest = new Thread() 
        {
            @Override
            public void run() {
                while (true) {
                    if(myBulletPlant.getHealth() == 0) //? ini jga sama bisa pake factory cman nanti aja
                    {
                        break;
                    }
                    myBulletPlant.checkToUseAbility();
                    // myPeashooter2.checkToUseAbility();
                    // latch.countDown();
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
                    if(myPoleVaultingZombie.getHealth() == 0) //? could use zombie factory to check if all living zombie is dead cman nanti aja
                    {
                        break;
                    }

                    myPoleVaultingZombie.refreshZombie();
                    x.refreshZombie();
                    y.refreshZombie();
                    // latch.countDown();
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

        // try{
        //     latch.await();
        // }
        // catch(InterruptedException e)
        // {
        //     e.printStackTrace();
        // }

        Thread gameThreadTest = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(map.isProtectedBaseCompromised())
                    {
                        break;
                    }
                    final long currentTime = System.currentTimeMillis() - startTime;
                    final long elapsedSeconds = currentTime/1000;
                    final long secondsDisplay = elapsedSeconds % 60;
                    final long minutesDisplay = elapsedSeconds / 60;
                    System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
                    map.printMap();
                    map.isProtectedBaseCompromised();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        gameThreadTest.start();
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