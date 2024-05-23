package Zombies;

// import GameMap.GameMap;
import Position.Position;
import ZombieAbility.*;
// import Petak.Petak;
// import Creature.Creature;
// ort Plants.Plant;

// Tiap 20 detik, health-nya nambah 25

public class RegenerativeZombie extends Zombie implements ZombieAbility {

    private boolean abilityUsed;

    public RegenerativeZombie(){
        super("Regenerative Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
        this.abilityUsed = false;
    }

    @Override
    public void useAbility() {
        this.setHealth(this.getHealth() + 50); // Menambah health sebesar 50
        abilityUsed = true;
    }
    

    @Override
    public void checkToUseAbility() {
        if (!abilityUsed && getHealth() <= 50) {
            useAbility();
        }
    }
}

