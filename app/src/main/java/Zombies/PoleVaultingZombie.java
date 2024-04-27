package Zombies;

import Position.Positition;

public class PoleVaultingZombie extends Zombie{

    public PoleVaultingZombie()
    {
        super("Pole Vaulting Zombie", 175, 100, 1, false,  new Positition(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Pole Vaulting Zombie vaults over plants!");
    }
    
}
