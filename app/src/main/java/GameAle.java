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

        // BulletPlant myBulletPlant = new BulletPlant();
        Squash mySquash = new Squash();
        Snowpea mySnowpea = new Snowpea();
        Peashooter myPeashooter = new Peashooter();
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

        
        Position posP23 = new Position(2, 3);
        map.getPetak(posP23).addCreature(myConeheadZombie);
        map.getPetak(posP23).addCreature(myDolphinRiderZombie);

        Position posP51 = new Position(5, 1);
        map.getPetak(posP51).addCreature(mySnowpea);

        Position posP58 = new Position(5, 8);
        map.getPetak(posP58).addCreature(myPoleVaultingZombie);

        mySun.displayStatus();
        map.printMap(); 


        // myBulletPlant.useAbility();
        mySunflower.useAbility();
        mySquash.useAbility();
        mySnowpea.useAbility();
        myPeashooter.useAbility();

        // mySquash.displayStatus();


        map.refreshMap();

        map.printMap();
        mySun.displayStatus();


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