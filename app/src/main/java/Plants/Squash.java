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
        bullet = new SquashBullet(getAttackDamage());
    }

}
