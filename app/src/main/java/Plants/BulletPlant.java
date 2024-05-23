package Plants;

import Position.Position;
import PlantAbility.*;
import Bullet.Bullet;
import Bullet.BasicBullet;
import GameMap.GameMap;
import Petak.Petak;

import java.util.ArrayList;
import java.util.List;

public class BulletPlant extends Plant implements PlantAbility {

    private BasicBullet bullet;
    private List<Petak> reachablePetak = new ArrayList<Petak>();

    public BulletPlant() {
        super("Bullet Plant", 100, 100, 35, 2, -1, 10, new Position(0, 0));
        bullet = new BasicBullet(getAttackDamage());
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
                if (!(p.getZombies().isEmpty())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void useAbility() {
        for (Petak p : reachablePetak) {
            synchronized (p) {
                if (!(p.getZombies().isEmpty())) {
                    if (!(bullet.isWornOut())) {
                        bullet.hit(p);
                    } else {
                        break;
                    }
                }
            }
        }
        setAttackTimer(getAttackSpeed());
        bullet = new BasicBullet(getAttackDamage());
    }

    @Override
    public void checkToUseAbility() {
        if (isZombiesInRange() && getAttackTimer() == 0) {
            useAbility();
        } else if (getAttackTimer() > 0) {
            setAttackTimer(getAttackTimer() - 1);
        } else if (!(isZombiesInRange()) && getAttackTimer() == 0) {
            // System.out.printf("No zombies in range for %s\n", getName());
        }
    }

}