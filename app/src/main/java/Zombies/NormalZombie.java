package Zombies;

import Position.Position;

public class NormalZombie extends Zombie{

    public NormalZombie()
    {
        super("Normal Zombie", 125, 100, 1, false,  new Position(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Normal Zombie walks slowly.");
    }
    
}
