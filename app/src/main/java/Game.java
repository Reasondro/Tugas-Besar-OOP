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
        map.getPetak(posZ2).addCreature(new DoubleAttackZombie());
        
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
    // GameMap map = GameMap.getInstance();


    // Menempatkan ZigzagZombie di posisi awal (2, 2)
    StinkZombie zigzagZombie = new StinkZombie();
    Position initialPosition = new Position(1, 1); // Disesuaikan dengan indexing 1-based
    zigzagZombie.setPos(initialPosition);
    Petak initialPetak = map.getPetak(initialPosition);
    initialPetak.addCreature(zigzagZombie);

    // Mencetak posisi awal
    System.out.println("Initial Position: " + zigzagZombie.getPos().getX() + ", " + zigzagZombie.getPos().getY());

    // Memanggil useAbility untuk menggerakkan zombie
    // zigzagZombie.useAbility();

    // Mencetak posisi baru setelah bergerak
    Position newPosition = zigzagZombie.getPos();
    System.out.println("New Position: " + newPosition.getX() + ", " + newPosition.getY());

    // Verifikasi apakah posisi sesuai dengan gerakan zigzag yang diharapkan
    if (initialPosition.getY() % 2 == 0) {
        if (newPosition.getX() == initialPosition.getX() + 1 && newPosition.getY() == initialPosition.getY()-1) {
            System.out.println("The zigzag movement is correct for even column.");
        } else {
            System.out.println("The zigzag movement is incorrect for even column.");
        }
    } else {
        if (newPosition.getX() == initialPosition.getX() - 1 && newPosition.getY() == initialPosition.getY()-1) {
            System.out.println("The zigzag movement is correct for odd column.");
        } else {
            System.out.println("The zigzag movement is incorrect for odd column.");
        }
    }

    // Menampilkan peta sebelum dan sesudah pergerakan untuk verifikasi visual
    System.out.println("Before using ability:");
    map.printMap();

    zigzagZombie.useAbility();

    System.out.println("After using ability:");
    map.printMap();

    zigzagZombie.useAbility();
    System.out.println("Kedua kali");
    map.printMap();

    zigzagZombie.useAbility();
    System.out.println("Ketiga");
    map.printMap();
    }
        
   
    }
