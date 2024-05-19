package Zombies;

import Position.Position;
import ZombieAbility.*;
import Petak.Petak;
import GameMap.GameMap;
// import Plants.Plant;

// Kalau depannya tanaman, tanamannya mati
// Cuma bisa dipake 2 kali ability-nya


public class StinkZombie extends Zombie implements ZombieAbility {
    

    
    public StinkZombie()
    {
        super("Stink Zombie", 100, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility() {
    }

    @Override
    public void checkToUseAbility() {

    }


}
