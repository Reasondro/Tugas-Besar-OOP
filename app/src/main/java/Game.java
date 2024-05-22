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
 // Inisialisasi game map
    GameMap gameMap = GameMap.getInstance();

 // Buat instance Sunflower dan StingZombie
    Kernelpult sun = new Kernelpult();
    StingZombie stingZombie = new StingZombie();

 // Set posisi Sunflower dan tambahkan ke petak
    Position sunPosition = new Position(2, 2); // Sesuaikan dengan posisi yang diinginkan
    sun.setPos(sunPosition);
    gameMap.getPetak(sunPosition).addCreature(sun);

 // Set posisi StingZombie dan tambahkan ke petak
    Position stingZombiePosition = new Position(2, 3); // Sesuaikan dengan posisi yang diinginkan
    stingZombie.setPos(stingZombiePosition);
    gameMap.getPetak(stingZombiePosition).addCreature(stingZombie);

 // Cek dan gunakan ability StingZombie
    System.out.println(sun.getHealth());
    System.out.println(stingZombie.getHealth());
    System.out.println("Before");
    gameMap.printMap();
    // kernel.useAbility();
    stingZombie.useAbility();
    stingZombie.walk();

 // Tampilkan health Sunflower setelah diserang
    System.out.println("Health Sunflo setelah diserang: " + sun.getHealth());
    System.out.println("Health zombie " + stingZombie.getHealth());
    gameMap.printMap();
}

    }

