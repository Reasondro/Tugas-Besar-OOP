package Plants;
import Position.Position;
import PlantAbility.*;
import Bullet.Bullet;
import Bullet.BasicBullet;
import GameMap.GameMap;
import Petak.Petak;

import java.util.List;



public class BulletPlant extends Plant implements PlantAbility{

    private BasicBullet bullet;

    public BulletPlant()
    {
        super("Bullet Plant", 100, 125, 175, 1, -1, 10,  new Position(0, 0));
        bullet = new BasicBullet(getAttackDamage());
    }

    public Bullet getBullet()
    {
        return bullet;
    }

    @Override
    public void useAbility()
    {

        //TODO extract reduce cooldown timer outside the useAbility method.
        //TODO duplicate attackTimer check. One outside this class to check if to shoot.
        //TODO The other one is to check if there's actually enemy to shoot, if there's none, then don't shoot.

        List<Petak> reachablePetak =  GameMap.getInstance().getRowBasedOnPlantRange(this);
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
        bullet = new BasicBullet(getAttackDamage());
    }
    
}
