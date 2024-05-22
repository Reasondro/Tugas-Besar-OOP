package Plants;

import Position.Position;
import PlantAbility.*;
import Zombies.Zombie;
import java.util.List;
import Bullet.*;
import GameMap.GameMap;
import Petak.Petak;
import java.util.ArrayList;

public class Kernelpult extends Plant implements PlantAbility {
   
    private List<Petak> reachablePetak = new ArrayList<>();
    private CornBullet corn;
    private ButterBullet butter;
    private int changeBulletTimer = 5;

    public Kernelpult() {
        super("Kernelpult", 200, 200, 30, 6, -1, 10, new Position(0, 0));
        corn = new CornBullet(getAttackDamage());
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
        corn = new CornBullet(getAttackDamage());
        for (Petak p : reachablePetak) {
            synchronized (p) {
                if (!p.getZombies().isEmpty()) {
                    corn.hit(p);
                    changeBulletTimer -= 1;
                }
                else{
                    break;
                }
            }
        }
        setAttackTimer(getAttackSpeed()); 

        if(changeBulletTimer == 0)
        {
            butter = new ButterBullet(getAttackDamage());
            corn = new CornBullet(getAttackDamage());
        }
        else 
        {
            corn = new CornBullet(getAttackDamage());
        }
    }

    @Override
    public void checkToUseAbility() {
        if (isZombiesInRange() && getAttackTimer() == 0) {
            useAbility();
            changeBulletTimer -= 1;
        } else if (getAttackTimer() > 0) {
            setAttackTimer(getAttackTimer() - 1);
        } else if (!isZombiesInRange() && getAttackTimer() == 0) {
            System.out.printf("No zombies in range for %s\n", getName());
        }
    }
}