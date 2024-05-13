package Zombies;

import Position.Position;
import ZombieAbility.*;

public class FlagZombie extends Zombie implements ZombieAbility {
    
    public FlagZombie(){
        super("Flag Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility(){
        System.out.println("The Flag Zombie waves its flag, rallying the undead horde to march forward relentlessly.");
    }
}
