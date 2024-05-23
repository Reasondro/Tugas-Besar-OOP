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
        super("Tangle", 50, 50, 100, 1, -1, 0, new Position(0, 0)); // Damage tentative
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
        if (isZombiesInRange()) {
            Petak currentPetak = GameMap.getInstance().getPetak(getPos());
            List<Zombie> zombies = currentPetak.getZombies();
            if (!zombies.isEmpty()) {
                Zombie target = zombies.get(0); // Tangling the first zombie in the petak
                target.setHealth(0); // Kill the zombie
                setHealth(0); // Tangle dies right after tangling the zombie
                System.out.println("Tangle tangles a zombie and both die!");
            }
        }
    }

    @Override
    public void checkToUseAbility() {
        if (isZombiesInRange()) {
            useAbility();
        }
    }
}