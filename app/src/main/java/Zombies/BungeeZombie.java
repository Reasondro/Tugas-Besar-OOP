package Zombies;

import Position.Position;
import ZombieAbility.*;
import Petak.Petak;
import GameMap.GameMap;
import Plants.Plant;

// Belum aku tes run, tapi intinya si zombie tuh lgsg ada di petak tempat tanaman berada (Bingung, positionnya berarti diganti biar gak 00 ga?)
// Terus nanti tanamannya langsung hilang (aku hapus dari petak?)


public class BungeeZombie extends Zombie implements ZombieAbility {
    
    private boolean hasUsedZombieAbility = false;
    
    public BungeeZombie()
    {
        super("Bungee Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    private boolean isPlantInSamePetak() {
        return !GameMap.getInstance().getPetak(getPos()).getPlants().isEmpty();
    }

    @Override
    public void useAbility() {
        if (isPlantInSamePetak() && !hasUsedZombieAbility) {
            Petak currentPetak = GameMap.getInstance().getPetak(getPos());
            Plant plant = currentPetak.getPlants().get(0);

            // Hapus tanaman dari petak
            currentPetak.removeCreature(plant);


            hasUsedZombieAbility = true;
        }
    }

    @Override
    public void checkToUseAbility() {
        if (isPlantInSamePetak() && !hasUsedZombieAbility) {
            useAbility();
        }
    }


}
