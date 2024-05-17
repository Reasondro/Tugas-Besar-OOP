package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;

public class Tangle extends Plant implements PlantAbility{
    
    private List<Zombie> targets = new ArrayList<>();
    private boolean aquatic;

    public Tangle()
    {
        super("Tangle", 25, 50, 25, 1, -1, 0,  new Position(0, 0)); // ini msh gatau krn dia kerjanya nenggelemin 1 zombie trus dia jg ikutan mati
        this.aquatic = aquatic;
    }

    public boolean isAquatic() {
        return aquatic;
    }
    
    public void setTargets(List<Zombie> targets)
    {
        this.targets = targets;
    }

    public void addTarget(Zombie z)
    {
        targets.add(z);
    }

    public void removeTarget(Zombie z)
    {
        targets.remove(z);
    }

    @Override
    public void useAbility() {
        if (getPos().isAquatic()) { // Memeriksa apakah tanaman berada di air
            for (Zombie z : targets) {
                // Mengurangi kesehatan zombie menjadi 0 (Membunuh zombie)
                z.setHealth(0);
            }
            // Set health of Tangle to 0 (Menghilangkan Tangle)
            setHealth(0);
        } else {
            System.out.println("Tangle can only be planted in water!");
        }
    }

     @Override
    public void checkToUseAbility() {
    }


}

