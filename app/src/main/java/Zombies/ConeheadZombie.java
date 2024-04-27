package Zombies;

import Position.Positition;

public class ConeheadZombie extends Zombie{
    
    public ConeheadZombie()
    {
        super("Conehead Zombie", 250, 100, 1, false,  new Positition(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Conehead Zombie has a cone on its head!");
    }
}
