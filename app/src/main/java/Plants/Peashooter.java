package Plants;

import Position.Position;

import PlantAbility.*;
import Bullet.PeaBullet;

import java.util.List;
import java.util.ArrayList;
import GameMap.GameMap;
import Petak.Petak;


public class Peashooter extends Plant implements PlantAbility{

    
    private PeaBullet bullet;
    private List<Petak> reachablePetak = new ArrayList<Petak>();

    
    public Peashooter()
    {
        super("Peashooter", 100, 100, 25, 4, -1, 10,  new Position(0, 0));
        bullet =  new PeaBullet(getAttackDamage());
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
            bullet = new PeaBullet(getAttackDamage());
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
