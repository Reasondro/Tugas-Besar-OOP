package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;

import Bullet.KernelBullet;
import GameMap.GameMap;
import Petak.Petak;

import java.util.ArrayList;

public class Kernelpult extends Plant implements PlantAbility {
   
    private KernelBullet bullet;
    private List<Petak> reachablePetak = new ArrayList<>();
    private int shotCounter = 0;

    public Kernelpult() {
        super("Kernelpult", 200, 300, 100, 6, -1, 10, new Position(0, 0));
        bullet = new KernelBullet(getAttackDamage());
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
    public void useAbility() {
        List<Zombie> targets = getTargets(); // Assuming getTargets() is defined in Plant or PlantAbility
        for (Zombie z : targets) {
            if (shotCounter == 5) { // Every 5 shots, switch to butter, this butter will freeze zombie
                z.reduceHealth(getAttackDamage()); // Apply damage
                z.setFrozenTimer(10); // Set frozen timer for 10 seconds
                if (!z.isFrozen()) {
                    z.setFrozen(true);
                }
                shotCounter = 0; // Reset counter after shooting butter
            } else {
                z.reduceHealth(getAttackDamage()); // Apply damage with corn kernel
            }
        }
        shotCounter++;
    }

    @Override
    public void checkToUseAbility() {
        if (isZombiesInRange()) {
            useAbility();
        }
    }

    // Assuming theres a getTargets() method that retrieves the list of zombies in range
    private List<Zombie> getTargets() {
        List<Zombie> targets = new ArrayList<>();
        for (Petak p : reachablePetak) {
            targets.addAll(p.getZombies());
        }
        return targets;
    }
}
