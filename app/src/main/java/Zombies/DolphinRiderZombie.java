package Zombies;

import Position.Position;
import Petak.Petak;
import GameMap.GameMap;
import Creature.Creature;
import Plants.Plant;
import ZombieAbility.*;

// Maaf belum di tes-run juga :(
// Bismillah bisa jalan :))

public class DolphinRiderZombie extends Zombie implements ZombieAbility {

    private boolean hasUsedZombieAbility = false;

    public DolphinRiderZombie() {
        super("Dolphin Rider Zombie", 175, 100, 1, 0,true,  new Position(0, 0));
    }

    private boolean isInPoolArea() {
        Petak currentPetak = GameMap.getInstance().getPetak(getPos());
        return "Pool".equals(currentPetak.getType());
    }

    private boolean isPlantInFront() {
        Petak petakInFront = GameMap.getInstance().getPetakInFrontOfZombie(this);

        for (Creature c : petakInFront.getCreatures()) {
            if (c instanceof Plant) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void useAbility() {
        if (isPlantInFront() && !hasUsedZombieAbility) {
            Petak petakInFront = GameMap.getInstance().getPetakInFrontOfZombie(this);
            Plant plant = petakInFront.getPlants().get(0);

            // Remove the plant from the map
            petakInFront.removeCreature(plant);


            hasUsedZombieAbility = true;
        }
    }

    @Override
    public void checkToUseAbility() {
        if (isInPoolArea() && !hasUsedZombieAbility && isPlantInFront()) {
            useAbility();
        }
    }

    @Override
    public void walk() {
        if (isInPoolArea()) {
            checkToUseAbility();
            super.walk(); // Utilize the walk method from the Zombie class
        } else {
            System.out.println("Dolphin Rider Zombie can only move in the pool area.");
        }
    }
}
