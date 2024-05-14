package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.ArrayList;
import java.util.List;

import Bullet.Bullet;
import Bullet.SnowBullet;
import GameMap.GameMap;
import Petak.Petak;


public class Snowpea extends Plant  implements PlantAbility{

    private SnowBullet bullet;
    private List<Petak> reachablePetak = new ArrayList<Petak>();

    public Snowpea()
    {
        super("Snow pea", 50, 100, 25, 1, -1, 10,  new Position(0, 0));
        bullet =  new SnowBullet(getAttackDamage());
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
            if(!(p.getZombies().isEmpty()))
            {
                return true;
            }
        }
        return false;
    }


    @Override
    public void useAbility()
    {
        for(Petak p : reachablePetak)
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
            setAttackTimer(getAttackSpeed()); 
            bullet = new SnowBullet(getAttackDamage());
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
