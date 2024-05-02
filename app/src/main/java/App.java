import Plants.*;
import Zombies.*;
import Sun.*;
import java.util.*;
public class App { 
    public static void main(String[] args)  {

        // Lilypad lilypad = new Lilypad();
        // lilypad.displayStatus();

        Squash p = new Squash();
        p.displayStatus();
        
        NormalZombie z = new NormalZombie();
        z.displayStatus();

        System.out.println("Zombie Health :" + z.getHealth());
        p.addTarget(z);
        p.useAbility();
        System.out.println("Zombie Health :" + z.getHealth());

        //? Yes, correct zombinya masi bisa attack padahal sudah dead. SEKEDAR testing untuk sementara, implementasi nanti akan diubah

        System.out.println("Plant Health:" + p.getHealth());
        z.attackPlant(p);
        System.out.println("Plant Health:" + p.getHealth());

        Sun sun = new Sun();
        sun.displayStatus();

        Sunflower sunflower = new Sunflower();
        sunflower.useAbility();

        sun.displayStatus();


        // Game.main(args);

    }
}
//? kita harus gradle build di file yg ada si buildny. 
