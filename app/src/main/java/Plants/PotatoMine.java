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

<<<<<<< HEAD
=======
    
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
    public boolean isZombiesInSamePetak() {
        return !GameMap.getInstance().getPetak(getPos()).getZombies().isEmpty();
    }

<<<<<<< HEAD
    public List<Petak> getReachablePetak() {
        return reachablePetak;
    }

=======
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

>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
    public void setReachablePetak(List<Petak> reachablePetak) {
        this.reachablePetak = reachablePetak;
    }

    // Override method from PlantAbility interface to handle using the ability
    @Override
<<<<<<< HEAD
    public void useAbility() {
        if (isReady && isZombiesInSamePetak()) {
            Petak currentPetak = GameMap.getInstance().getPetak(getPos());
            List<Zombie> zombies = currentPetak.getZombies();
            for (Zombie z : zombies) {
                z.reduceHealth(z.getHealth()); // Instant kill zombies --> zombies dies
            }
            setHealth(0); // Set health of PotatoMine to 0 (remove PotatoMine cuz it's already exploded)
            System.out.println("PotatoMine explodes and vanishes!");
        } else {
            System.out.println("PotatoMine is not ready yet!");
=======
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
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
        }
    }

    // Implement checkToUseAbility method from PlantAbility interface
    @Override
<<<<<<< HEAD
    public void checkToUseAbility() {
        if (isReady && isZombiesInSamePetak()) {
            useAbility();
        }
    }
}
=======
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
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
