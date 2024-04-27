import Plants.*;
import Zombies.*;
public class App { 
    public static void main(String[] args) {

    Lilypad lilypad = new Lilypad();
    lilypad.displayStatus();
    lilypad.useAbility();

    ConeheadZombie coneheadZombie = new ConeheadZombie();
    coneheadZombie.displayStatus();
    coneheadZombie.useAbility();


    }
}
//? kita harus gradle build di file yg ada si buildny. 
