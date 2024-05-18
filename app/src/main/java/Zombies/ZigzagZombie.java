package Zombies;

import Position.Position;
import ZombieAbility.*;
import Petak.Petak;
import GameMap.GameMap;
// import Plants.Plant;

// Zombie-nya jalan zigzag


public class ZigzagZombie extends Zombie implements ZombieAbility {
    

    
    public ZigzagZombie()
    {
        super("Zigzag Zombie", 100, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility() {
        GameMap gameMap = GameMap.getInstance();
        Position currentPosition = this.getPos();
        Petak currentPetak = gameMap.getPetak(currentPosition);
        Petak nextPetak;

        if (currentPosition.getY() % 2 == 0) {
            // Ke bawah kalo di kolom genap
            nextPetak = gameMap.getPetak(new Position(currentPosition.getX() + 1, currentPosition.getY()-1));
        } else {
            // Ke atas kalau kolomnya ganjil
            nextPetak = gameMap.getPetak(new Position(currentPosition.getX() - 1, currentPosition.getY()-1));
        }

        
        currentPetak.removeCreature(this);
        nextPetak.addCreature(this);
        this.setPos(nextPetak.getPos());
       
    }

    @Override
    public void checkToUseAbility() {

    }


}
