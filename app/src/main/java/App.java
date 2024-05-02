import Plants.*;
import Zombies.*;
import java.util.*;
public class App { 
    public static void main(String[] args)  {

        // Lilypad lilypad = new Lilypad();
        // lilypad.displayStatus();

        Squash p = new Squash();
        // p.displayStatus();
        
        NormalZombie z = new NormalZombie();
        // normalZombie.displayStatus();

        System.out.println("Zombie Health :" + z.getHealth());
        p.addTarget(z);
        p.useAbility();
        System.out.println("Zombie Health :" + z.getHealth());

        System.out.println("Plant Health:" + p.getHealth());
        z.attackPlant(p);
        System.out.println("Plant Health:" + p.getHealth());

    





        // Game.main(args);

    }
}
//? kita harus gradle build di file yg ada si buildny. 
