package Zombies;

import Position.Position;
import ZombieAbility.*;

import Position.Position;
import Petak.Petak;
import GameMap.GameMap;

public class PoleVaultingZombie extends Zombie implements ZombieAbility {

    private float abilityTimer = 0;
    private Petak petakInFront;
    private boolean hasUseZombieAbility = false;

    public PoleVaultingZombie()
    {
        super("Pole Vaulting Zombie", 175, 100, 1, 0,false,  new Position(0, 0));
    }

    public Petak getPetakInFront()
    {
        return petakInFront;
    }

    public void setPetakInFront(Petak petakInFront)
    {
        this.petakInFront = petakInFront;
    }

    public boolean isPlantInFront()
    {
        //TODO implement this
        return false;
        // setPetakInFront(GameMap.getInstance());
    }

    @Override
    public void useAbility()
    {



     }

    @Override
    public void checkToUseAbility(){}
    
}
