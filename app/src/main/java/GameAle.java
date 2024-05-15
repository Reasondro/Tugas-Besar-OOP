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
        map.getPetak(posP51).addCreature(myPeashooter2);

        Position posP58 = new Position(5, 8);
        map.getPetak(posP58).addCreature(myPoleVaultingZombie);

        Position posP62 = new Position(6, 2);
        map.getPetak(posP62).addCreature(myBulletPlant);

        //? below for non thread testing
        map.printMap(); 

        System.out.println("After removing all plants from petak 1,1 (sunflower and peashooter are gone)");
        map.getPetak(posP11).removeAllPlants(); //? remove all plants from petak @mhmmdhakim
        map.printMap(); 



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

        final long  startTime =  System.currentTimeMillis();
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(myPoleVaultingZombie.getHealth() == 0)
                    {
                        break;
                    }
                    final long currentTime = System.currentTimeMillis() - startTime;
                    final long elapsedSeconds = currentTime/1000;
                    final long secondsDisplay = elapsedSeconds % 60;
                    final long minutesDisplay = elapsedSeconds / 60;
                    System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
                    // System.out.println("Minutes passed: " + minutesDisplay);
                    // map.printMap();
                    // System.out.println("----------");
                    // System.out.println("NEW SESSION");
                    // System.out.println("My Peashooter attack timer: " + myPeashooter.getAttackTimer());
                    // myPeashooter.checkToUseAbility();
                    // System.out.println("----------");
                    System.out.println("My Peashooter2 attack timer: " + mySnowpea.getAttackTimer() );
                    myPeashooter2.checkToUseAbility();
                    System.out.println("My Snowpea attack timer: " + mySnowpea.getAttackTimer());
                    mySnowpea.checkToUseAbility();

                    // System.out.println("FINISH SESSION");
                    // System.out.print("----------");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        // thread.start();

    }
}
///? Notes before adding bullet


        //   // Squash p = new Squash();
        // // p.displayStatus();
        
        // // NormalZombie z = new NormalZombie();
        // // z.displayStatus();

        // // System.out.println("Zombie Health :" + z.getHealth());
        // // p.addTarget(z);
        // // p.useAbility();
        // // System.out.println("Zombie Health :" + z.getHealth());

        // // //? Yes, correct zombinya masi bisa attack padahal sudah dead. SEKEDAR testing untuk sementara, implementasi nanti akan diubah

        // // System.out.println("Plant Health:" + p.getHealth());
        // // z.attackPlant(p);
        // // System.out.println("Plant Health:" + p.getHealth());

        // // Sun sun = new Sun();
        // // sun.displayStatus();

        // // Sunflower sunflower = new Sunflower();
        // // sunflower.useAbility();

        // // sun.displayStatus();
        // // Petak petak = new Petak("Normal", new Position(0, 0));
        // // petak.printType();
        // // petak.addCreature(new NormalZombie());
        // // petak.addCreature(new Sunflower());
        // // petak.addCreature(new NormalZombie());
        // // petak.printCreature();
        // GameMap map = GameMap.getInstance();
        // // System.out.println("Before adding creature");
        // // map.printMap();

        // Position posZ = new Position(1, 9);
        // NormalZombie myZombie = new NormalZombie();
        // map.getPetak(posZ).addCreature(myZombie);

        // // Position posZ2 = new Position(3, 8);
        // // map.getPetak(posZ2).addCreature(new ConeheadZombie());
        
        // Position posP11 = new Position(1, 1);

        // Snowpea mySnowpea = new Snowpea();
        // BulletPlant myBulletPlant = new BulletPlant();

        // map.getPetak(posP11).addCreature(myBulletPlant);

        // Position posP16 = new Position(1, 6);
        // Peashooter myPeashooter = new Peashooter();
        // map.getPetak(posP16).addCreature(myPeashooter);


        // Position posP13 = new Position(1, 3);
        // NormalZombie myZombie2 = new NormalZombie();
        // map.getPetak(posP13).addCreature(myZombie2);

        // // Position posP2 = new Position(3, 2);
        // // map.getPetak(posP2).addCreature(new Sunflower());
        // // map.getPetak(posP2).addCreature(new Lilypad());
        // // map.getPetak(posP2).addCreature(new ConeheadZombie());

        // // Position posP3 = new Position(6, 3);
        // // map.getPetak(posP3).addCreature(new Sunflower());




        // // System.out.println("After adding creature");
        // // System.out.println("Before using ability");
        // // map.printMap();

        // // myPeashooter.setTargets(map.getPetak(posZ).getZombies());
        // // myPeashooter.useAbility();
        // // myPeashooter.useAbility();
        // // myPeashooter.useAbility();
        // // myPeashooter.useAbility();
        // // myPeashooter.useAbility();

        // // mySnowpea.setTargets(map.getPetak(posZ).getZombies());
        // // mySnowpea.useAbility();

        // // myZombie.displayStatus();
        // // System.out.println("After using ability");
        // map.refreshMap();
        // map.printMap(); 
        // // myBulletPlant.displayStatus();
        // // List<Petak> test = map.getRowBasedOnPlantRange(myBulletPlant);
        // // System.out.println("Petak yang bisa dijangkau Bullet Plant");
        // // for(Petak p : test)
        // // {
            
        // //     System.out.println(p.getPos().getX() + " " + p.getPos().getY());
        // // }
        // myBulletPlant.useAbility();
        
        // // List<Petak> test2 = map.getRowBasedOnPlantRange(myPeashooter);
        // // System.out.println("Petak yang bisa dijangkau Peashooter");
        // // for(Petak p : test2)
        // // {
            
        // //     System.out.println(p.getPos().getX() + " " + p.getPos().getY());
        // // }

 

/////


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