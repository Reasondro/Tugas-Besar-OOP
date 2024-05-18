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

    Position pos = new Position(2, 5); // Misalnya zombie ditempatkan di petak baris 2, kolom 5
    DoubleAttackZombie zombie = new DoubleAttackZombie();
    map.getPetak(pos).addCreature(zombie);

    zombie.useAbility();

    // Memeriksa apakah useAbility telah berjalan tanpa kesalahan
    Petak currentPetak = GameMap.getInstance().getPetak(pos);
    if (currentPetak.getPlants().isEmpty()) {
        System.out.println("Ability of BungeeZombie used successfully!");
    } else {
        System.out.println("Error: Ability of BungeeZombie not used!");
    }

    Position flagZombiePos = new Position(2, 5); // Posisi zombie
    FlagZombie flagZombie = new FlagZombie();
    map.getPetak(flagZombiePos).addCreature(flagZombie);
    flagZombie.setPos(flagZombiePos);

    // Membuat tanaman untuk uji coba
    Position plantPos = new Position(2, 5); // Posisi tanaman
    Sunflower sunflower = new Sunflower();
    map.getPetak(plantPos).addCreature(sunflower);
    sunflower.setPos(plantPos);

    // Menampilkan peta sebelum menggunakan ability
    System.out.println("Before using ability:");
    map.printMap();

    // Memanggil useAbility langsung
    flagZombie.useAbility();

    // Menampilkan peta setelah menggunakan ability
    System.out.println("After using ability:");
    map.printMap();

    // Mengecek apakah ability berhasil digunakan
    Petak petakFlagZombie = GameMap.getInstance().getPetak(flagZombiePos);
    Petak petakNewZombie = GameMap.getInstance().getPetak(new Position(2, 0)); // Posisi zombie baru di kolom pertama

    if (petakNewZombie.getCreatures().stream().anyMatch(c -> c instanceof FlagZombie)) {
        System.out.println("Flag Zombie ability worked: New zombie spawned successfully!");
    } else {
        System.out.println("Error: New zombie not spawned.");
    }

    // Mengecek apakah statistik zombie telah meningkat
    if (flagZombie.getHealth() > 150 && flagZombie.getAttackDamage() > 100) {
        System.out.println("Flag Zombie ability worked: Zombie stats increased successfully!");
    } else {
        System.out.println("Error: Zombie stats not increased.");
    }
    }
}