package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;

import Bullet.KernelBullet;
import Bullet.PeaBullet;
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
    public void useAbility()
    {
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
            setAttackTimer(getAttackSpeed()); 
            bullet = new KernelBullet(getAttackDamage());
    }

    @Override
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
            System.out.printf("No zombies in range for %s\n", getName());
        }
    }

}
