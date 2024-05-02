package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;
import java.util.List;

public class Peashooter extends Plant implements PlantAbility{

    
    private List<Zombie> targets;

    
    public Peashooter()
    {
        super("Peashooter", 100, 100, 25, 1, -1, 10,  new Position(0, 0));
    }

    public void setTargets(List<Zombie> targets)
    {
        this.targets = targets;
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
