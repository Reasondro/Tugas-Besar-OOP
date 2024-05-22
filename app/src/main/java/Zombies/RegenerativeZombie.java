package Zombies;

// import GameMap.GameMap;
import Position.Position;
import ZombieAbility.*;
// import Petak.Petak;
// import Creature.Creature;
// ort Plants.Plant;

// Tiap 20 detik, health-nya nambah 25

public class RegenerativeZombie extends Zombie implements ZombieAbility {

    private long lastRegenerationTime;
    private static final long REGENERATION_INTERVAL = 20000; // 20 detik 

    public RegenerativeZombie(){
        super("Regenerative Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
        this.lastRegenerationTime = System.currentTimeMillis();
    }

    @Override
    public void useAbility() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastRegenerationTime >= REGENERATION_INTERVAL) {
            regenerate();
            lastRegenerationTime = currentTime;
        }
    }

    @Override
    public void checkToUseAbility() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastRegenerationTime >= REGENERATION_INTERVAL) {
            useAbility();
        }
    }

    private void regenerate() {
        if (this.getHealth() > 0) { // Pastikan zombie masih hidup
            this.setHealth(this.getHealth() + 25);
        }
    }
}
