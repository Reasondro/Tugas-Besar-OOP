package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;

public class Peashooter extends Plant implements PlantAbility{

    
    private List<Zombie> targets = new ArrayList<>();

    
    public Peashooter()
    {
        super("Peashooter", 100, 100, 25, 1, -1, 10,  new Position(0, 0));
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
           z.reduceHealth(getAttackDamage());
        }
    }

}
