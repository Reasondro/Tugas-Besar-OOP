package Zombies;

import Position.Position;
import ZombieAbility.*;

public class BungeeZombie extends Zombie implements ZombieAbility {
    public BungeeZombie()
    {
        super("Bungee Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility(){
        System.out.println("Bungee Zombie is destroying the house!");
    }
}
