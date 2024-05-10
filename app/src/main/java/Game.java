import java.util.*;

import GameMap.GameMap;
import Plants.*;
import Zombies.*;
import Sun.*;
import java.util.*;
import Petak.*;
import Position.*;

public class Game {
    public static void main(String[] args)
    {

          // Squash p = new Squash();
        // p.displayStatus();
        
        // NormalZombie z = new NormalZombie();
        // z.displayStatus();

        // System.out.println("Zombie Health :" + z.getHealth());
        // p.addTarget(z);
        // p.useAbility();
        // System.out.println("Zombie Health :" + z.getHealth());

        // //? Yes, correct zombinya masi bisa attack padahal sudah dead. SEKEDAR testing untuk sementara, implementasi nanti akan diubah

        // System.out.println("Plant Health:" + p.getHealth());
        // z.attackPlant(p);
        // System.out.println("Plant Health:" + p.getHealth());

        // Sun sun = new Sun();
        // sun.displayStatus();

        // Sunflower sunflower = new Sunflower();
        // sunflower.useAbility();

        // sun.displayStatus();
        // Petak petak = new Petak("Normal", new Position(0, 0));
        // petak.printType();
        // petak.addCreature(new NormalZombie());
        // petak.addCreature(new Sunflower());
        // petak.addCreature(new NormalZombie());
        // petak.printCreature();
        GameMap map = GameMap.getInstance();
        System.out.println("Before adding creature");
        map.printMap();

        Position posZ = new Position(1, 9);
        map.getPetak(posZ).addCreature(new NormalZombie());

        Position posZ2 = new Position(3, 8);
        map.getPetak(posZ2).addCreature(new ConeheadZombie());
        
        Position posP = new Position(1, 1);
        map.getPetak(posP).addCreature(new Sunflower());

        Position posP2 = new Position(3, 2);
        map.getPetak(posP2).addCreature(new Sunflower());
        map.getPetak(posP2).addCreature(new Lilypad());
        map.getPetak(posP2).addCreature(new ConeheadZombie());

        Position posP3 = new Position(6, 3);
        map.getPetak(posP3).addCreature(new Sunflower());



        System.out.println("After adding creature");
        map.printMap();
        












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
    }
}