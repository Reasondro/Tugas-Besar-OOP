package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.ArrayList;
import java.util.List;


public class Snowpea extends Plant  implements PlantAbility{

    private List<Zombie> targets = new ArrayList<>();

    public Snowpea()
    {
        super("Snow pea", 50, 100, 25, 1, -1, 10,  new Position(0, 0));
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
            z.setFrozenTimer(3);
            if(z.isFrozen() == false)
            {
                z.setFrozen(true);
                z.setWalkSpeed(z.getWalkSpeed() / 2);
            }
        }
    }
    


}
