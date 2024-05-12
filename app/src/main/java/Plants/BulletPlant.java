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
        List<Petak> reachablePetak =  GameMap.getInstance().getRowBasedOnPlantRange(this);
        for(Petak p : reachablePetak)
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
