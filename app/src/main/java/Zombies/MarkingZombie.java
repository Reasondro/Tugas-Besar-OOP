package Zombies;

import java.util.List;

import GameMap.GameMap;
import Petak.Petak;
import Position.Position;
import ZombieAbility.*;

// Petak yang udh dilewati oleh zombie ini, ga bs ditanami tanaman 

public class MarkingZombie extends Zombie implements ZombieAbility {

    private List<Petak> markedPetak;

    public MarkingZombie()
    {
        super("Marking Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility() {
        // Dapatkan posisi zombie saat ini
        Position currentPosition = getPos();
        // Dapatkan petak saat ini berdasarkan posisi zombie
        Petak currentPetak = GameMap.getInstance().getPetak(currentPosition);
        // Tandai petak saat ini
        markedPetak.add(currentPetak);
    }

    @Override
    public void checkToUseAbility(){
        
    }

}
