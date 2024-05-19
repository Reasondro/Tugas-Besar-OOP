package Zombies;

import GameMap.GameMap;
import Position.Position;
import ZombieAbility.*;
// import Petak.Petak;
// import Creature.Creature;
// ort Plants.Plant;

// Tiap 20 detik, health-nya nambah 25

public class RegenerativeZombie extends Zombie implements ZombieAbility {

    private boolean hasUsedZombieAbility = false;
    
    public RegenerativeZombie(){
        super("Flag Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    public void increaseStats() {
        // Meningkatkan statistik zombie secara drastis
        int currentHealth = getHealth();
        int currentAttackDamage = getAttackDamage();

        setHealth(currentHealth * 2);
        setAttackDamage(currentAttackDamage * 2);
    }

    public void spawnNewZombie() {
        // Bikin zombie baru
        Position spawnPosition = new Position(getPos().getX(), 0); // Posisi yang sama kaya zombie sekarang dan spawn di kolom pertama
        Zombie newZombie = new RegenerativeZombie(); // Ini masih eror
        GameMap.getInstance().getPetak(spawnPosition).addCreature(newZombie);
        System.out.println("Flag Zombie telah menghasilkan zombie baru!");
    }

    @Override
    public void useAbility() {
        if (!hasUsedZombieAbility) {
            increaseStats();
            spawnNewZombie(); // Panggil method buat bikin zombie baru
            hasUsedZombieAbility = true;
        }
    }

    @Override
    public void checkToUseAbility() {
        if (GameMap.getInstance().getPetak(getPos()).getType().equals("ZombieSpawnArea") && !hasUsedZombieAbility) {
            useAbility();
        }
    }

    @Override
    public void walk() {
        // Flag Zombie berjalan seperti zombie biasa
        super.walk();
    }
}
