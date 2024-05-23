package Plants;

import Position.Position;
import PlantAbility.*;
import Zombies.Zombie;
import java.util.List;
<<<<<<< HEAD
import Bullet.KernelBullet;
import Bullet.PeaBullet;
=======

import Bullet.Bullet;
import Bullet.ButterBullet;
import Bullet.CornBullet;
>>>>>>> 9186814e083d63137b730951023fe19ecb633c41
import GameMap.GameMap;
import Petak.Petak;
import java.util.ArrayList;

public class Kernelpult extends Plant implements PlantAbility {
   
<<<<<<< HEAD
    private List<Petak> reachablePetak = new ArrayList<>();
    private KernelBullet bullet;

    public Kernelpult() {
        super("Kernelpult", 200, 300, 100, 6, -1, 10, new Position(0, 0));
        bullet =  new KernelBullet(getAttackDamage());
    }

    public List<Petak> getReachablePetak() {
        return reachablePetak;
    }

    public void setReachablePetak(List<Petak> reachablePetak) {
        this.reachablePetak = reachablePetak;
    }

=======
    private Bullet bullet;
    private List<Petak> reachablePetak = new ArrayList<>();
   
    private int changeBulletTimer = 0;

    public Kernelpult() {
        super("Kernelpult", 200, 200, 30, 6, -1, 10, new Position(0, 0));
        bullet = new ButterBullet(getAttackDamage());}

    public List<Petak> getReachablePetak() {
        return reachablePetak;
    }

    public void setReachablePetak(List<Petak> reachablePetak) {
        this.reachablePetak = reachablePetak;
    }

>>>>>>> 9186814e083d63137b730951023fe19ecb633c41
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
<<<<<<< HEAD
        KernelBullet bullet = new KernelBullet(getAttackDamage());
        for (Petak p : reachablePetak) {
            synchronized (p) {
                if (!p.getZombies().isEmpty()) {
                    bullet.hit(p);
                }
                else{
                    break;
                }
            }
        }
        setAttackTimer(getAttackSpeed()); 
        bullet = new KernelBullet(getAttackDamage());
    }

=======
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

>>>>>>> 9186814e083d63137b730951023fe19ecb633c41
    @Override
    public void checkToUseAbility() {
        if (isZombiesInRange() && getAttackTimer() == 0) {
            useAbility();
        } else if (getAttackTimer() > 0) {
            setAttackTimer(getAttackTimer() - 1);
        } else if (!isZombiesInRange() && getAttackTimer() == 0) {
            System.out.printf("No zombies in range for %s\n", getName());
        }
    }
}