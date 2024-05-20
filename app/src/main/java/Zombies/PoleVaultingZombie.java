package Zombies;

import Position.Position;
import ZombieAbility.*;
import Petak.Petak;
import GameMap.GameMap;
import Creature.Creature;
import Plants.Plant;

public class PoleVaultingZombie extends Zombie implements ZombieAbility {

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
        setPetakInFront(GameMap.getInstance().getPetakInFrontOfZombie(this));
        
        for(Creature c : petakInFront.getCreatures())
        {
            if(c instanceof Plant)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void useAbility()
    {
            // Plant plant = petakInFront.getPlants().get(0);
            // plant.reduceHealth(plant.getHealth());
            // hasUseZombieAbility = true;

            //? vaulting logic
            Position pos = getPos();
            Petak currentPetak = GameMap.getInstance().getPetak(pos); 
            synchronized (currentPetak )
            {
            currentPetak.removeCreature(this);

            int currentY = pos.getY();
            int newY = currentY - 2;
            if(newY <1)
            {
                newY = -99; //? to prevent the zombie jumping out of bounds 
            }
            pos.setY(newY);

            Petak landingPetak = GameMap.getInstance().getPetak(pos);
            landingPetak.addCreature(this);

            if(landingPetak.getPlants().isEmpty())
            {
                return;
            }

            Plant plant = landingPetak.getPlants().get(0);
            plant.reduceHealth(plant.getHealth());
            hasUseZombieAbility = true;
            }
     }

    @Override
    public void checkToUseAbility()
    {
        if(isPlantInFront() && !hasUseZombieAbility && getHealth() > 0)
        {
            useAbility();
        }
    }
    
}
