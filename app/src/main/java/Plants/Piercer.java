package Plants;

import Position.Position;

import PlantAbility.*;
<<<<<<< HEAD
import Zombies.Zombie;
import Bullet.PeaBullet;
=======
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
import Bullet.PiercerBullet;

import java.util.List;
import java.util.ArrayList;
import GameMap.GameMap;
import Petak.Petak;


public class Piercer extends Plant implements PlantAbility{
    
    private PiercerBullet bullet;
    private List<Petak> reachablePetak = new ArrayList<Petak>();

    public Piercer()
    {
<<<<<<< HEAD
        super("Piercer", 120, 100, 80, 0, 0, 0,  new Position(0, 0));
=======
        super("Piercer", 120, 100, 15, 0, -1, 10,  new Position(0, 0));
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
        bullet =  new PiercerBullet(getAttackDamage());
    }   
    

    public List<Petak> getReachablePetak()
    {
        return reachablePetak;
    }

    public void setReachablePetak(List<Petak> reachablePetak)
    {
        this.reachablePetak = reachablePetak;
    }

    public boolean isZombiesInRange()
    {
        setReachablePetak(GameMap.getInstance().getRowBasedOnPlantRange(this));
        for(Petak p : reachablePetak)
        {
            synchronized(p)
            {
                if(!(p.getZombies().isEmpty()))
                {
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
            bullet = new PiercerBullet(getAttackDamage());
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
            // System.out.printf("No zombies in range for %s\n", getName());
        }
    }
}
