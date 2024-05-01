package Zombies;

import Position.Position;

public class DolphinRiderZombie extends Zombie{

    public DolphinRiderZombie()
    {
        super("Dolphin Rider Zombie", 175, 100, 1, true,  new Position(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Dolphin Rider Zombie rides a dolphin!");
    }
    
}
