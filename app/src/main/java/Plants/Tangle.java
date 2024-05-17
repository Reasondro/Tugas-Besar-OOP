package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;

public class Tangle extends Plant implements PlantAbility{
    
    private List<Zombie> targets = new ArrayList<>();

    public Tangle()
    {
        super("Tangle", 25, 50, 25, 1, -1, 0,  new Position(0, 0)); // ini msh gatau krn dia kerjanya nenggelemin 1 zombie trus dia jg ikutan mati
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
<<<<<<< HEAD
=======
    @Override
    public void checkToUseAbility(){}

>>>>>>> 3e53d023249f1d81858b027eb24d490f7f648c8f

}

