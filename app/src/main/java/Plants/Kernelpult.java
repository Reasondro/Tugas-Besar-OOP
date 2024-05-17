package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;

public class Kernelpult extends Plant implements PlantAbility{
   
    private List<Zombie> targets = new ArrayList<>();

    public Kernelpult()
    {
        super("Kernelpult", 200, 300, 100, 6, -1, 10,  new Position(0, 0)); // masih tentatif damage dia berapa
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
<<<<<<< HEAD
        for(Zombie z : targets)
        {
            z.reduceHealth(getAttackDamage());
            z.setFrozenTimer(10);
            if(z.isFrozen() == false)
            {
                z.setFrozen(true);
                z.setWalkSpeed(z.getWalkSpeed() / 2);
            }
        }
    }
=======
        // for(Zombie z : targets)
        // {
        //     z.reduceHealth(getAttackDamage());
        //     z.setFrozenTimer(10);
        //     if(z.isFrozen() == false)
        //     {
        //         z.setFrozen(true);
        //         z.setWalkSpeed(z.getWalkSpeed() / 2);
        //     }
        // }
    }
    @Override
    public void checkToUseAbility(){}

>>>>>>> 3e53d023249f1d81858b027eb24d490f7f648c8f
    
}
