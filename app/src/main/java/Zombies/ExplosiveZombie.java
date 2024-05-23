package Zombies;

// import java.util.List;

// import Creature.Creature;
import GameMap.GameMap;
import Petak.Petak;
import Plants.Plant;
import Position.Position;
import ZombieAbility.*;

// Taneman depan zombie ini mati
// Tapi abistu, zombienya jg mati
// pake remove creature

public class ExplosiveZombie extends Zombie implements ZombieAbility {

  

    public ExplosiveZombie()
    {
        super("Explosive Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility() {
        GameMap map = GameMap.getInstance();
        Position currentPosition = this.getPos();
        Petak currentPetak = map.getPetak(currentPosition);
        Petak frontPetak = map.getPetakInFrontOfZombie(this);

        // if (frontPetak != null && !frontPetak.getPlants().isEmpty()) {
            // Ambil taneman di depan
            Plant plant = frontPetak.getPlants().get(0);
            plant.reduceHealth(plant.getHealth()); // Set health tanaman ke 0

            // Membunuh zombie itu sendiri
            this.reduceHealth(this.getHealth()); // Set health zombie ke 0
            currentPetak.removeCreature(this); // Hapus zombie dari petak saat 
            // Not sure if plant harus di-remove juga nggak? Harusnya iya
    
    }

    @Override
    public void checkToUseAbility() {
        GameMap map = GameMap.getInstance();
        Petak frontPetak = map.getPetakInFrontOfZombie(this);

        if (frontPetak != null && !frontPetak.getPlants().isEmpty()) {
            useAbility(); // Gunakan ability jika ada tanaman di petak depan
        }
    }

}
