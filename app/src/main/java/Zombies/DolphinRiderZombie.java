package Zombies;

import Position.Positition;

public class DolphinRiderZombie extends Zombie{

    public DolphinRiderZombie()
    {
        super("Dolphin Rider Zombie", 175, 100, 1, true,  new Positition(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Dolphin Rider Zombie rides a dolphin!");
    }
    
}
