package Zombies;

import Position.Position;
import ZombieAbility.*;
import Petak.Petak;
import GameMap.GameMap;
// import Plants.Plant;

// Zombie-nya jalan zigzag


public class ZigzagZombie extends Zombie implements ZombieAbility {
    
    private boolean hasUsedZombieAbility = false;
    
    public ZigzagZombie()
    {
        super("Bungee Zombie", 100, 100, 1, 1,false,  new Position(0, 0));
    }

    private boolean isPlantInSamePetak() {
        return !GameMap.getInstance().getPetak(getPos()).getPlants().isEmpty();
    }

    @Override
    public void useAbility() {
        GameMap gameMap = GameMap.getInstance();
        Position currentPosition = this.getPos();
        Petak currentPetak = gameMap.getPetak(currentPosition);
        Petak nextPetak;

        if (currentPosition.getY() % 2 == 0) {
            // Ke bawah kalo di kolom genap
            nextPetak = gameMap.getPetak(new Position(currentPosition.getX() + 1, currentPosition.getY()));
        } else {
            // Ke atas kalau kolomnya ganjil
            nextPetak = gameMap.getPetak(new Position(currentPosition.getX() - 1, currentPosition.getY()));
        }

        
        currentPetak.removeCreature(this);
        nextPetak.addCreature(this);
        this.setPos(nextPetak.getPos());
       
    }

    @Override
    public void checkToUseAbility() {
        if (isPlantInSamePetak() && !hasUsedZombieAbility) {
            useAbility();
        }
    }


}
