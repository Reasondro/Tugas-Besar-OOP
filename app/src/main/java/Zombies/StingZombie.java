package Zombies;

import Position.Position;
import ZombieAbility.*;
import Petak.Petak;
import Plants.Plant;
import GameMap.GameMap;
// import Plants.Plant;

// Kalau depannya tanaman, tanamannya mati
// Cuma bisa dipake 1 kali ability-nya


public class StingZombie extends Zombie implements ZombieAbility {
    
    private boolean abilityUsed;
    
    public StingZombie()
    {
        super("Sting Zombie", 100, 100, 1, 1,false,  new Position(0, 0));
        this.abilityUsed = false;
    }

    @Override
    public void useAbility() {
        if (!abilityUsed) {
            // Mencari tanaman di depan zombie
            GameMap gameMap = GameMap.getInstance();
            // Position currentPosition = this.getPos();
            Petak inFrontOfZombie = gameMap.getPetakInFrontOfZombie(this);

            if (!inFrontOfZombie.getPlants().isEmpty()) {
                // Menyerang tanaman di depan
                Plant targetPlant = inFrontOfZombie.getPlants().get(0); // Mengambil tanaman pertama di depan zombie
                int currentPlantHealth = targetPlant.getHealth();
                // int damageDealt = this.getAttackDamage();

                // Mengurangi kesehatan tanaman dengan serangan jarak jauh
                targetPlant.reduceHealth(currentPlantHealth); // Langsung membunuh tanaman

                // System.out.println(this.getName() + " killed " + targetPlant.getName() + " from distance.");

                abilityUsed = true; // Menandai bahwa kemampuan telah digunakan
            }
        }
    }

    @Override
    public void checkToUseAbility() {
        if (!abilityUsed) {
            useAbility();
        }
    }


}