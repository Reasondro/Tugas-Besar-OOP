package Plants;

import Position.Position;
import PlantAbility.*;
<<<<<<< HEAD
import Zombies.Zombie;
=======
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
import java.util.List;

import Bullet.Bullet;
import Bullet.ButterBullet;
import Bullet.CornBullet;
import GameMap.GameMap;
import Petak.Petak;
import java.util.ArrayList;

public class Kernelpult extends Plant implements PlantAbility {
   
    private Bullet bullet;
    private List<Petak> reachablePetak = new ArrayList<>();
   
    private int changeBulletTimer = 0;

    public Kernelpult() {
<<<<<<< HEAD
        super("Kernelpult", 200, 200, 30, 6, -1, 10, new Position(0, 0));
=======
        super("Kernelpult", 140, 200, 30, 6, -1, 10, new Position(0, 0));
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
        bullet = new ButterBullet(getAttackDamage());}

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
            for(Petak p : reachablePetak)
            {
                synchronized(p) //TODO add synchronized to objects that need(petak)
                {
                if(!(p.getZombies().isEmpty()))
                {
                    if(!(bullet.isWornOut()))
                    {
                    bullet.hit(p);
                    }
                    else
                    {
                        break;
                    }     
                }
                }
            }
        changeBulletTimer--;
        setAttackTimer(getAttackSpeed()); 

        if(changeBulletTimer == 0)
        {
            bullet = new ButterBullet(getAttackDamage());
            changeBulletTimer = 5;
        }
        else 
        {
            bullet = new CornBullet(getAttackDamage());
        }
    }

    @Override
    public void checkToUseAbility() {
        if (isZombiesInRange() && getAttackTimer() == 0) {
            useAbility();
        } else if (getAttackTimer() > 0) {
            setAttackTimer(getAttackTimer() - 1);
        } else if (!isZombiesInRange() && getAttackTimer() == 0) {
<<<<<<< HEAD
            System.out.printf("No zombies in range for %s\n", getName());
=======
            // System.out.printf("No zombies in range for %s\n", getName());
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
        }
    }
}