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
        //TODO extract reduce cooldown timer outside the useAbility method
        // if(getAttackTimer() == 0)
        // {
            List<Petak> reachablePetak =  GameMap.getInstance().getRowBasedOnPlantRange(this);
            for(Petak p : reachablePetak)
            {
                    if(!(p.getZombies().isEmpty()))
                    {
                        if(!(bullet.isWornOut()))
                        {
                        bullet.hit(p);
                        setAttackTimer(getAttackSpeed());   
                        }
                        else
                        {
                            break;
                        }
                    }
            }
            bullet.setWornOut(false);
        // }
        // else
        // {
        //     setAttackTimer(getAttackTimer()-1);
        // }
}
    

}
