package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;

import GameMap.GameMap;
import Petak.Petak;

import java.util.ArrayList;

public class Tangle extends Plant implements PlantAbility {

    private List<Petak> reachablePetak = new ArrayList<>();
    
    public Tangle() {
        super("Tangle", 50, 50, 5000, 0, 1, 10, new Position(0, 0)); // Damage tentative
    }

    public List<Petak> getReachablePetak() {
        return reachablePetak;
    }

    public void setReachablePetak(List<Petak> reachablePetak) {
        this.reachablePetak = reachablePetak;
    }

    public boolean isZombiesInRange() {
        setReachablePetak(GameMap.getInstance().getRowBasedOnPlantRange(this));
        for (Petak p : reachablePetak) {
            synchronized (p) {
                if (!p.getZombies().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
<<<<<<< HEAD
    public void useAbility() {
        if (isZombiesInRange()) {
            Petak currentPetak = GameMap.getInstance().getPetak(getPos());
            List<Zombie> zombies = currentPetak.getZombies();
            if (!zombies.isEmpty()) {
                Zombie target = zombies.get(0); // Tangling the first zombie in the petak
                target.setHealth(0); // Kill the zombie
                setHealth(0); // Tangle dies right after tangling the zombie
                System.out.println("Tangle tangles a zombie and both die!");
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
                    // System.out.printf("Hit %s with damage %d\n", z.getName(), getAttackDamage());
                    // System.out.printf("%s went from %d HP to %d HP\n", z.getName(), originalHealth, z.getHealth());
                }
                reduceHealth(getHealth()); //? kill the tanlge
                } 
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
            }
        }
    }

    @Override
<<<<<<< HEAD
    public void checkToUseAbility() {
        if (isZombiesInRange()) {
            useAbility();
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
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
    }
}