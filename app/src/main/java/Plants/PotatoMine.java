package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;

public class PotatoMine extends Plant implements PlantAbility{

    private List<Zombie> targets = new ArrayList<>();
    
    public PotatoMine()
    {
        super("PotatoMine", 25, 400, 180, 1, -1, 0,  new Position(0, 0)); // masih tentatif damage dia berapa
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
    public void useAbility( )
    {
        for(Zombie z : targets)
        {
           z.reduceHealth(z.getHealth()); //? instant kill
        }
    }

}

