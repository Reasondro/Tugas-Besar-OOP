package Zombies;

import Position.Position;
import ZombieAbility.*;

import Position.Position;
import Petak.Petak;
import GameMap.GameMap;

public class PoleVaultingZombie extends Zombie implements ZombieAbility {

    private float abilityTimer = 0;
    private Petak petakInFront;

    public PoleVaultingZombie()
    {
        super("Pole Vaulting Zombie", 175, 100, 1, 0,false,  new Position(0, 0));
    }


    @Override
    public void useAbility()
    {



     }

    @Override
    public void checkToUseAbility(){}
    
}
