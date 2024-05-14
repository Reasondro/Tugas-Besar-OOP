package Zombies;

import Position.Position;
import ZombieAbility.*;

public class DolphinRiderZombie extends Zombie implements ZombieAbility{

    public DolphinRiderZombie()
    {
        super("Dolphin Rider Zombie", 175, 100, 1, 1,true,  new Position(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Dolphin Rider Zombie rides a dolphin!");
    }

    @Override
    public void checkToUseAbility(){}
    
}
