package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;


import GameMap.GameMap;
import Petak.Petak;


public class Squash  extends Plant implements PlantAbility{

    private List<Petak> reachablePetak = new ArrayList<Petak>();

    
    public Squash()
    {
        super("Squash", 50, 100, 5000, 0, 1, 20,  new Position(0, 0));
    }

    public List<Petak> getReachablePetak()
    {
        return reachablePetak;
    }

    public void setReachablePetak(List<Petak> reachablePetak)
    {
        this.reachablePetak = reachablePetak;
    }
    
    public boolean isZombiesInRange()
    {
        setReachablePetak(GameMap.getInstance().getRowBasedOnPlantRange(this));
        for(Petak p : reachablePetak)
        {
            synchronized(p)
            {
                if(!(p.getZombies().isEmpty()))
                {
                    return true;
                }
            }
    }
        return false;
    }


    @Override
    public void useAbility( )
    {
        for(Petak p : reachablePetak)
        {
            synchronized(p)
            {
                if(!(p.getZombies().isEmpty()))
                {
                    for(Zombie z : p.getZombies())
                    {
                    // int originalHealth = z.getHealth();
                    z.reduceHealth(getAttackDamage()); //? instant kill zombie
                    // System.out.printf("Hit %s with damage %d\n", z.getName(), getAttackDamage());
                    // System.out.printf("%s went from %d HP to %d HP\n", z.getName(), originalHealth, z.getHealth());
                    reduceHealth(getHealth()); //? kill the squash
                    }
                } 
            }
        }
    }
    @Override
    public void checkToUseAbility()
    {
        if (isZombiesInRange() && getAttackTimer() == 0)
        {
            useAbility();
        }
        else if(getAttackTimer() > 0)
        {
            setAttackTimer(getAttackTimer()-1);
        }
        else if(!(isZombiesInRange()) && getAttackTimer() == 0)
        {
            // System.out.printf("No zombies in range for %s\n", getName());
        }
    }

}