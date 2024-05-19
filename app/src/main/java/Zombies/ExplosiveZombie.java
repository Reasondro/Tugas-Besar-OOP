package Zombies;

import java.util.List;

import GameMap.GameMap;
import Petak.Petak;
import Position.Position;
import ZombieAbility.*;

// Taneman depan zombie ini mati
// Tapi abistu, zombienya jg mati
// pake remove creature

public class ExplosiveZombie extends Zombie implements ZombieAbility {

  

    public ExplosiveZombie()
    {
        super("Explosive Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility() {

    }

    @Override
    public void checkToUseAbility(){
        
    }

}
