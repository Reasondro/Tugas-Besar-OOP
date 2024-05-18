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
        super("PotatoMine", 25, 400, 180, 1, -1, 0, new Position(0, 0)); // Tentative damage
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

    // Override method from PlantAbility interface to handle using the ability
    @Override
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
