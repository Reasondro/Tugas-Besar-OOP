package Zombies;

import Position.Positition;

public class NormalZombie extends Zombie{

    public NormalZombie()
    {
        super("Normal Zombie", 125, 100, 1, false,  new Positition(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Normal Zombie walks slowly.");
    }
    
}
