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

    public Snowpea()
    {
        super("Snow pea", 50, 100, 25, 1, -1, 10,  new Position(0, 0));
        bullet =  new SnowBullet(getAttackDamage());
    }


    @Override
    public void useAbility( )
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
