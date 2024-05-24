package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;

import GameMap.GameMap;
import Petak.Petak;

import java.util.ArrayList;

public class PotatoMine extends Plant implements PlantAbility {

    private List<Petak> reachablePetak = new ArrayList<>();
    
    public PotatoMine() {
        super("PotatoMine", 150, 200, 50, 1, -1, 10, new Position(0, 0)); // Tentative damage
    }
    
    // Uncomment and implement refreshCreature if needed
    // @Override
    // public void refreshCreature() {
    //     super.refreshCreature();
    //     if (!isReady) {
    //         if (getCooldown() == 0) {
    //             isReady = true;
    //             System.out.println("PotatoMine is ready to explode!");
    //         }
    //     }
    // }

    
    public boolean isZombiesInSamePetak() {
        return !GameMap.getInstance().getPetak(getPos()).getZombies().isEmpty();
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

    public List<Petak> getReachablePetak() {
        return reachablePetak;
    }

    public void setReachablePetak(List<Petak> reachablePetak) {
        this.reachablePetak = reachablePetak;
    }

    // Override method from PlantAbility interface to handle using the ability
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
                    z.setAttackDamage(z.getAttackDamage()/2);
                    z.setFrozenTimer(5);
                    if(z.isFrozen() == false)
                    {
                        z.setFrozen(true);
                        z.setWalkSpeedInSeconds(z.getWalkSpeedInSeconds() * 2);
                    }
                    reduceHealth(getHealth()); //? kill the squash


                    // System.out.printf("Hit %s with damage %d\n", z.getName(), getAttackDamage());
                    // System.out.printf("%s went from %d HP to %d HP\n", z.getName(), originalHealth, z.getHealth());
                    
                    }
                } 
            }
        }
    }

    // Implement checkToUseAbility method from PlantAbility interface
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
