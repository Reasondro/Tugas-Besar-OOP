package Zombies;

import Position.Position;

public class PoleVaultingZombie extends Zombie{

    public PoleVaultingZombie()
    {
        super("Pole Vaulting Zombie", 175, 100, 1, false,  new Position(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Pole Vaulting Zombie vaults over plants!");
    }
    
}
