package Zombies;

import Position.Position;
import ZombieAbility.*;

public class DancingZombie extends Zombie implements ZombieAbility {
    
    public DancingZombie(){
        super("Dancing Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility(){
        System.out.println("The Dancing Zombie summoning backup dancers!");
    }
}
