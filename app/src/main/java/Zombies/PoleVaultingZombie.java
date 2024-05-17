package Zombies;

import Position.Position;
import ZombieAbility.*;

// import Position.Position;
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

        if(isPlantInFront() && !hasUseZombieAbility)
        {
            Plant plant = petakInFront.getPlants().get(0);

            int originalHealth = plant.getHealth();
            plant.reduceHealth(plant.getHealth());

            System.out.println("Pole Vaulting Zombie jumps over " + plant.getName());
            System.out.printf("%S health went from %d to %d\n", plant.getName() ,originalHealth , plant.getHealth());

            hasUseZombieAbility = true;
        }

     }

    @Override
    public void checkToUseAbility(){}
    
}
