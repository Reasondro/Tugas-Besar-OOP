package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;

import GameMap.GameMap;
import Petak.Petak;

import java.util.ArrayList;

public class PotatoMine extends Plant implements PlantAbility {

    private boolean isReady = false;
    private List<Petak> reachablePetak = new ArrayList<>();
    
    public PotatoMine() {
        super("PotatoMine", 25, 200, 50, 1, -1, 10, new Position(0, 0)); // Tentative damage
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

    public List<Petak> getReachablePetak() {
        return reachablePetak;
    }

    public void setReachablePetak(List<Petak> reachablePetak) {
        this.reachablePetak = reachablePetak;
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
                    z.setAttackDamage(z.getAttackDamage()/2);
                    // System.out.printf("Hit %s with damage %d\n", z.getName(), getAttackDamage());
                    // System.out.printf("%s went from %d HP to %d HP\n", z.getName(), originalHealth, z.getHealth());
                    
                    }
                } 
            }
        }
    }

    // Implement checkToUseAbility method from PlantAbility interface
    @Override
    public void checkToUseAbility() {
        if (isReady && isZombiesInSamePetak()) {
            useAbility();
        }
    }
}