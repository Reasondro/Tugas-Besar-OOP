import java.util.*;

import Creature.Creature;
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
        Kernelpult myKernel = new Kernelpult();
        NormalZombie myNormalZombie = new NormalZombie();

        
        Position posP11 = new Position(1, 1);
        map.getPetak(posP11).addCreature(myKernel);

        mySun.displayStatus();
        map.printMap(); 
        
        Position posP19 = new Position(1, 2);
        map.getPetak(posP19).addCreature(myNormalZombie);
        map.refreshMap();
        myNormalZombie.walk();


        Position posP58 = new Position(5, 8);

        Position posP62 = new Position(6, 2);
        map.getPetak(posP62).addCreature(myBulletPlant);

        myKernel.useAbility();
        myNormalZombie.checkToAttack();
        myKernel.useAbility();


        myKernel.displayStatus();
        myNormalZombie.displayStatus();
        map.printMap(); 
    }
}
        // System.out.println(Creature.Zombie.NormalZombie.getHealth());



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


//         final long  startTime =  System.currentTimeMillis();
        
//         Thread plantThreadTest = new Thread() {
//             @Override
//             public void run() {
//                 while (true) {
//                     if(map.isProtectedBaseCompromised() || myNormalZombie.getHealth() == 0)
//                     {
//                         break;
//                     }
//                     final long currentTime = System.currentTimeMillis() - startTime;
//                     final long elapsedSeconds = currentTime/1000;
//                     final long secondsDisplay = elapsedSeconds % 60;
//                     final long minutesDisplay = elapsedSeconds / 60;
//                     System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
//                     map.printMap();
//                     // System.out.println("My Peashooter2 attack timer: " + mySnowpea.getAttackTimer() );
//                     // myPeashooter2.checkToUseAbility();
//                     // System.out.println("My Snowpea attack timer: " + mySnowpea.getAttackTimer());
//                     // mySnowpea.checkToUseAbility();

//                     try {
//                         Thread.sleep(1000);
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
//                 }
//             }
//         };

//         plantThreadTest.start();

//         Thread zombieThreadTest = new Thread() {
//             @Override
//             public void run() {
//                 while (true) {
//                     if(map.isProtectedBaseCompromised() || myNormalZombie.getHealth() == 0) //? could use zombie factory to check if all living zombie is dead
//                     {
//                         break;
//                     }
//                     // final long currentTime = System.currentTimeMillis() - startTime;
//                     // final long elapsedSeconds = currentTime/1000;
//                     // final long secondsDisplay = elapsedSeconds % 60;
//                     // final long minutesDisplay = elapsedSeconds / 60;
//                     // System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
//                     // System.out.println("My PoleVaultingZombie attack timer: " + myPoleVaultingZombie.getAttackTimer() );
                   
//                     // myPoleVaultingZombie.checkToWalk();
//                     // System.out.println("My PoleVaultingZombie walk timer: " + myPoleVaultingZombie.getWalkTimer());

//                     // myNormalZombie.checkToAttack();
//                     myNormalZombie.checkToWalk();
//                     try {
//                         Thread.sleep(1000);
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
//                 }
//             }
//         };
//         zombieThreadTest.start();
//         //? above for plant thread testing
//     }
// }
// ///? Notes before adding bullet























//    //     Game concurrency = new Game();
//     //     Thread thread = new Thread(() -> {
//     //         try {
//     //             while (true) {
//     //                 concurrency.gameLoop();
//     //                 Thread.sleep(1000); // Sleep for 1 second
//     //             }
//     //         } catch (InterruptedException e) {
//     //             System.out.println("Game Loop Interrupted");
//     //         }
//     //     });
//     //     thread.start();

//     //     boolean isRunning = true;
//     //     Scanner scanner = new Scanner(System.in);
//     //     String userInput;

//     //     while (isRunning) {
//     //         userInput = scanner.nextLine();
//     //         if (userInput.equals("exit")) {
//     //             isRunning = false;
//     //             thread.interrupt();
//     //             break;
//     //         } else {
//     //             System.out.println("Hello " + userInput + "!");
//     //         }
//     //     }

    //     scanner.close();
    // }

    // public void gameLoop() {
    //     System.out.println("Game Loop");