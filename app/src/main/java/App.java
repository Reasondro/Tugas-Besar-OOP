import Plants.*;
import Zombies.*;
import java.util.*;
public class App { 
    public static void main(String[] args)  {

        Lilypad lilypad = new Lilypad();
        lilypad.displayStatus();
        lilypad.useAbility();
        NormalZombie normalZombie = new NormalZombie();
        normalZombie.displayStatus();
        normalZombie.useAbility();

        // Game.main(args);

    }
}
//? kita harus gradle build di file yg ada si buildny. 
