package Zombies;

import Position.Position;
import Petak.Petak;
import GameMap.GameMap;
import Creature.Creature;
import Plants.Plant;
import ZombieAbility.*;
import Petak.Petak;
import GameMap.GameMap;
import Creature.Creature;
import Plants.Plant;
import java.util.List;
import java.util.ArrayList;

// Maaf belum di tes-run juga :(
// Bismillah bisa jalan :))
public class DolphinRiderZombie extends Zombie implements ZombieAbility{
    private Petak petakInFront;
    private boolean hasUseZombieAbility = false;

    public DolphinRiderZombie()
    {
        super("Dolphin Rider Zombie", 175, 100, 1, 0,true,  new Position(0, 0));
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

           List<Plant> plants = landingPetak.getPlants();
            
            for(Plant p : plants)
            {
                p.reduceHealth(p.getHealth());
            }
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
