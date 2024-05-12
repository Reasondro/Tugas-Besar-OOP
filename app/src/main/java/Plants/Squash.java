package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;

import Bullet.Bullet;
import Bullet.SquashBullet;
import GameMap.GameMap;
import Petak.Petak;


public class Squash  extends Plant implements PlantAbility{

    private SquashBullet bullet;
    
    public Squash()
    {
        super("Squash", 50, 100, 5000, 0, 1, 20,  new Position(0, 0));
        bullet =  new SquashBullet(getAttackDamage());
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
